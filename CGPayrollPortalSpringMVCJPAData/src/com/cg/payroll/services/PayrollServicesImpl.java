package com.cg.payroll.services;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.cg.payroll.beans.Associate;
import com.cg.payroll.beans.BankDetails;
import com.cg.payroll.beans.Salary;
import com.cg.payroll.daoservices.AssociateDAO;
import com.cg.payroll.exceptions.AssociateDetailNotfoundException;
@Component("payrollServices")
public class PayrollServicesImpl implements PayrollServices{
	
	@Autowired
	private AssociateDAO associateDao;
	
	@Override
	public Associate acceptAssociateDetails(Associate associate) {
		associate=associateDao.save(associate);
		return associate;
	}
	@Override
	        public int calculateNetSalary(int associateId) throws AssociateDetailNotfoundException {
			Associate associate=getAssociateDetails(associateId);
			Salary salary=associate.getSalary();
			int netSal=0,netMonSal=0,tax=0,netAunSal=0;
			int basicSalary=salary.getBasicSalary();
			int hra=(int)(basicSalary*(0.3));
			int coonveyenceAllowance=(int)(basicSalary*0.3);
			int otherAllowance=(int)(basicSalary*0.25);
			int	personalAllowance=(int)(basicSalary*0.2);
			salary.setHra(hra); salary.setCoonveyenceAllowance(coonveyenceAllowance); salary.setOtherAllowance(otherAllowance);
			salary.setPersonalAllowance(personalAllowance); 
			int totalSalary=((basicSalary+hra+coonveyenceAllowance+otherAllowance+personalAllowance+salary.getEpf()+salary.getCompanyPf())*12);
			salary.setGrossSalary(totalSalary);
			if(salary.getGrossSalary()>=1000000){
				int grossSalary=salary.getGrossSalary();
				int excessAmount=salary.getGrossSalary()-1000000;
				tax=(int)(excessAmount*(0.3));
				salary.setGrossSalary(salary.getGrossSalary()-excessAmount);
				int excessAmount1=salary.getGrossSalary()-500000;
				tax=tax+ (int)(excessAmount1*(0.2));
				salary.setGrossSalary(salary.getGrossSalary()-excessAmount1);
				int excessAmount2=salary.getGrossSalary()-250000;
				int fixedInvest=150000;
				int invest=Math.abs(fixedInvest-(((salary.getEpf()+salary.getCompanyPf())*12)+associate.getYearlyInvestmentUnder80C()));
				tax=(int) (tax+((invest+100000)*0.1));	
				 netAunSal=grossSalary-((salary.getEpf()+salary.getCompanyPf())*12)-tax;
				 netSal=netAunSal/12;
			}
			else if((salary.getGrossSalary()>=500000)&&(salary.getGrossSalary()<1000000)){
				int grossSalary=salary.getGrossSalary();
				int excessAmount1=salary.getGrossSalary()-500000;
				tax=tax+ (int)(excessAmount1*(0.2));
				salary.setGrossSalary(salary.getGrossSalary()-excessAmount1);
				int excessAmount2=salary.getGrossSalary()-250000;
				int fixedInvest=150000;
				int invest=Math.abs(fixedInvest-(((salary.getEpf()+salary.getCompanyPf())*12)+associate.getYearlyInvestmentUnder80C()));
				tax=(int) (tax+((invest+100000)*0.1));
				 netAunSal=grossSalary-((salary.getEpf()+salary.getCompanyPf())*12)-tax;
				 netSal=netAunSal/12;
			}
			else if((salary.getGrossSalary()>=250000)&&(salary.getGrossSalary()<500000)){
				int grossSalary=salary.getGrossSalary();
				int excessAmount2=salary.getGrossSalary()-250000;
				int fixedInvest=150000;
				int invest=Math.abs(fixedInvest-(((salary.getEpf()+salary.getCompanyPf())*12)+associate.getYearlyInvestmentUnder80C()));
				tax=(int) (tax+((invest+100000)*0.1));
				 netAunSal=grossSalary-((salary.getEpf()+salary.getCompanyPf())*12)-tax;
				 netSal=netAunSal/12;
			}
			else{
				int grossSalary=salary.getGrossSalary();
				 netAunSal=grossSalary-((salary.getEpf()+salary.getCompanyPf())*12);
				 netSal=netAunSal/12;
			}
			salary.setNetSalary(netSal);
			salary.setMonthlyTax(tax/12);
			associate.setSalary(salary);
			associate=associateDao.save(associate);	
		return netSal;
	}

	@Override
	public Associate getAssociateDetails(int associateId) throws AssociateDetailNotfoundException {
		Associate associate=associateDao.findById(associateId).orElseThrow(()->new AssociateDetailNotfoundException("Associate Details Not found for "+associateId));
	return associate;
	}

	@Override
	public List<Associate> getAllAssociateDetails() {	
		return associateDao.findAll() ;
	}
}

package com.cg.payroll.beans;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
@Entity
public class Associate {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int associateId;
	private int yearlyInvestmentUnder80C;
	@NotEmpty
	private String firstName;
	@NotEmpty
	private String lastName;
	@NotEmpty
	private String department;
	@NotEmpty
	private String designation;
	@NotEmpty
	private String pancard;
	@NotEmpty
	@Email
	private String emailId;
	@Embedded
	private BankDetails bankDetails;
	@Embedded
	private Salary salary;
	 public Associate() {}
	 public Associate(int yearlyInvestmentUnder80C, String firstName, String lastName, String department, String designation, String pancard, String emailId, BankDetails bankDetails, Salary salary) {
		this.yearlyInvestmentUnder80C=yearlyInvestmentUnder80C; 
		this.firstName=firstName;
		this.lastName=lastName;
		this.department=department;
		this.designation=designation;
		this.pancard=pancard;
		this.emailId=emailId;
		this.bankDetails=bankDetails;
		this.salary=salary;
	 }
	
	
	public Associate(int associateId, int yearlyInvestmentUnder8oC, String firstName, String lastName,
			String department, String designation, String pancard, String emailId, BankDetails bankDetails,
			Salary salary) {
		//super();
		this.associateId = associateId;
		this.yearlyInvestmentUnder80C = yearlyInvestmentUnder80C;
		this.firstName = firstName;
		this.lastName = lastName;
		this.department = department;
		this.designation = designation;
		this.pancard = pancard;
		this.emailId = emailId;
		this.bankDetails = bankDetails;
		this.salary = salary;
	}
	
	public int getAssociateId() {
		return associateId;
	}
	
	public void setAssociateId(int associateId) {
		this.associateId = associateId;
	}
	public int getYearlyInvestmentUnder80C() {
		return yearlyInvestmentUnder80C;
	}
	public void setYearlyInvestmentUnder8oC(int yearlyInvestmentUnder80C) {
		this.yearlyInvestmentUnder80C = yearlyInvestmentUnder80C;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getPancard() {
		return pancard;
	}
	public void setPancard(String pancard) {
		this.pancard = pancard;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + associateId;
		result = prime * result + ((department == null) ? 0 : department.hashCode());
		result = prime * result + ((designation == null) ? 0 : designation.hashCode());
		result = prime * result + ((emailId == null) ? 0 : emailId.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((pancard == null) ? 0 : pancard.hashCode());
		result = prime * result + yearlyInvestmentUnder80C;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Associate other = (Associate) obj;
		if (associateId != other.associateId)
			return false;
		if (department == null) {
			if (other.department != null)
				return false;
		} else if (!department.equals(other.department))
			return false;
		if (designation == null) {
			if (other.designation != null)
				return false;
		} else if (!designation.equals(other.designation))
			return false;
		if (emailId == null) {
			if (other.emailId != null)
				return false;
		} else if (!emailId.equals(other.emailId))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (pancard == null) {
			if (other.pancard != null)
				return false;
		} else if (!pancard.equals(other.pancard))
			return false;
		if (yearlyInvestmentUnder80C != other.yearlyInvestmentUnder80C)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Associate [associateId=" + associateId + ", firstName=" + firstName + ", lastName=" + lastName + ", department=" + department
				+ ", designation=" + designation + ", pancard=" + pancard + ", emailId=" + emailId + "]";
	}
	public BankDetails getBankDetails() {
		return bankDetails;
	}
	public void setBankDetails(BankDetails bankDetails) {
		this.bankDetails = bankDetails;
	}
	public Salary getSalary() {
		return salary;
	}
	public void setSalary(Salary salary) {
		this.salary = salary;
	}
	
}

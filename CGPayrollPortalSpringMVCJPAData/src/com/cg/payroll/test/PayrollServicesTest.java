package com.cg.payroll.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.cg.payroll.beans.Associate;
import com.cg.payroll.beans.BankDetails;
import com.cg.payroll.beans.Salary;
import com.cg.payroll.exceptions.AssociateDetailNotfoundException;
import com.cg.payroll.services.PayrollServices;
import com.cg.payroll.services.PayrollServicesImpl;

public class PayrollServicesTest {
	private static PayrollServices services;
	@Before
	public void setUpTestEnv() throws Exception {
		services=new PayrollServicesImpl();
	}
	/*@Test
	public void testGetAssociateDetailsForValidAssociateId() throws AssociateDetailNotfoundException {
		Associate expectedAssociate=new Associate(1, 4325, "ewsafe", "ewqf", "fewfewfr", "retewrt", "fdgdg", "gttgew", new BankDetails(34535, "gds", "erwgew"), new Salary(345, 103, 103, 86, 69, 0, 3455, 4353, 102168, 706));
		Associate actualAssociate=services.getAssociateDetails(1);
	}   */
/*	@Test 
	public void testAcceptAssociateDetailsForValidData() throws AssociateDetailNotfoundException {
		int expectedId=23; 
		int actualId=services.acceptAssociateDetails("ABD","singh","adsafd","dsfsf","fsf", "fdsf",24323, 213213,1000, 2232, 234324,"jlkds","hkjw"); 
		Assert.assertEquals(expectedId, actualId);
		 }
	*/
	@Test 
	public void testCalCulateNetSalaryForValidAssociateId() throws AssociateDetailNotfoundException { 
		int expectedSalary=86783; 
		int actualSalary=services.calculateNetSalary(2);
	  Assert.assertEquals(expectedSalary, actualSalary); 
	  }
	@After
	public void tearDownTestEnv() throws Exception {
		services=null;
	}



}

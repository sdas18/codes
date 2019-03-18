package com.cg.payroll.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cg.payroll.beans.Associate;
import com.cg.payroll.beans.Salary;

@Controller
public class URIController {
	private Associate associate;
	private Salary netSal;
@RequestMapping(value= {"/","index"})
public String getIndexPage() {
		return "IndexPage";}
@RequestMapping("/registration")
public String getRegistrationPage() {
	return "registrationPage";
}
@RequestMapping("/findAssociateDetails")
public String getFindAssociateDetailsPage() {
	return "findAssociateDetailsPage";
}
@RequestMapping("/netSalary")
public String getNetSalary() {
	return  "netSalary";
}
@ModelAttribute
public Associate getAssociate(){
	associate =new Associate();
	return associate;
}
}
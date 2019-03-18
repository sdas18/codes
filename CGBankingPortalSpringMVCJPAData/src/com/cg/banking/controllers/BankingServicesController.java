package com.cg.banking.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cg.banking.beans.Account;
import com.cg.banking.services.BankingServices;


@Controller
public class BankingServicesController {

	@Autowired
	BankingServices bankingservices;
	@RequestMapping("/openAccount1")
	public ModelAndView openaccount(@ModelAttribute Account account) {
		account =bankingservices.openAccount(account);
		return new ModelAndView("AccountDetails", "account", account);
	}

}


package com.cg.banking.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cg.banking.beans.Account;
@Controller
public class URIController {
private Account account;
@RequestMapping("/")
public String getIndexPage() {
	return "IndexPage";
}
@RequestMapping("/openAccount")
public String getOpenAccount() {
	return "OpenAccount";
}

}

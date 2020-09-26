package com.test.housebook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.test.housebook.service.AccountService;
import com.test.housebook.vo.AccountVO;

@Controller
@RequestMapping(value="/account")
public class AccountController {
	
	@Autowired
	private AccountService as;
	
	@RequestMapping(value="/joinForm", method=RequestMethod.GET)
	public String joinForm() {
		
		return "account/joinForm";
	}
	
	@RequestMapping(value="/join", method=RequestMethod.POST)
	public String join(AccountVO account) {
		
		String page = as.accountJoin(account);
		
		return page;
	}
	
	@RequestMapping(value="/loginForm", method=RequestMethod.GET)
	public String loginForm() {
		return "account/loginForm";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(AccountVO account) {
		
		String page = as.accountLogin(account);
		
		return page;
	}
	
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String logout() {
		as.logout();
		return "redirect:/";
	}

}

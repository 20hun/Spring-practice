package com.test.housebook.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.housebook.dao.AccountDAO;
import com.test.housebook.vo.AccountVO;

@Service
public class AccountService {
	
	@Autowired
	private AccountDAO dao;
	
	@Autowired
	private HttpSession session;

	public String accountJoin(AccountVO account) {
		
		int cnt = dao.accountJoin(account);
		
		String page = "";
		
		if(cnt == 0) {
			page = "redirect:/account/joinForm";
		}else {
			page = "redirect:/account/loginForm";
		}
		
		return page;
	}

	public String accountLogin(AccountVO account) {
		AccountVO loginCheck = dao.accountSelectOne(account.getAcc_id());
		
		String page = "";
		
		if(loginCheck != null && loginCheck.getAcc_pw().equals(account.getAcc_pw())) {
			session.setAttribute("loginId", account.getAcc_id());
			page = "redirect:/";
		} else {
			page = "redirect:/account/loginForm";
		}
		
		return page;
	}

	public void logout() {
		session.removeAttribute("loginId");
	}

}

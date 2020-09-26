package com.sesoc.web1;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sesoc.web1.vo.MemberVO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping(value = "/joinForm", method = RequestMethod.GET)
	public String join() {
		
		return "join";
	}
	
	 @RequestMapping(value = "/join2", method = RequestMethod.POST)
	 public String join2(MemberVO member) {
	 
			/*
			 * System.out.println("MemberVO(id="+member.getId()+", pw="+member.getPw()
			 * +", phone="+member.getP1()+"-"+member.getP2()+"-"+member.getP3()+")");
			 * string으로 010 치면 int로 들어갈 때 0은 필요 없으니 10만 저장
			 */
	 System.out.println(member);
		 
	 return "join2";
	 }
}
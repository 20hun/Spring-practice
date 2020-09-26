package com.sesoc.web21;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	private ArrayList<String> idList;
	
	public HomeController() {
		logger.info("HomeController 인스턴스 생성");
		
		idList = new ArrayList<String>();
		idList.add("hong1234");
		idList.add("dsd2134");
	}
	
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
	
	@RequestMapping(value = "/test1", method=RequestMethod.GET)
	public String test1() {
		return "test1";
	}
	
	@ResponseBody
	@RequestMapping(value="/idCheck", method = RequestMethod.GET, produces = "application/test;charset=utf-8;")
	public String idCheck(String id) {
		String result = "사용할 수 있는 ID입니다.";
		
		for(int i = 0; i< idList.size(); i++) {
			if(id.equals(idList.get(i))) {
				result= "사용 중인 ID입니다.";
				break;
			}
		}
		
		return result;
	}
	
	@RequestMapping(value = "/test2", method=RequestMethod.GET)
	public String test2() {
		return "test2";
	}
	
	@ResponseBody
	@RequestMapping(value="/first", method = RequestMethod.POST, produces = "application/test;charset=utf-8;")
	public void first(String userid, String userpw) {
		logger.info("first 메서드 실행.");
		logger.info("페이지로부터 전달받은 데이터: {}", userid);
		logger.info("페이지로부터 전달받은 데이터: {}", userpw);

	}
	
	@ResponseBody
	@RequestMapping(value="/second", method = RequestMethod.POST, produces = "application/test;charset=utf-8;")
	public void second(String[] arr) {
		logger.info("second 메서드 실행.");
		for(String i : arr) {
		logger.info("페이지로부터 전달받은 데이터: {}", i);
		}
	}
	
	@ResponseBody
	@RequestMapping(value="/third", method = RequestMethod.POST, produces = "application/test;charset=utf-8;")
	public void third(UserVO user) {
		logger.info("third 메서드 실행.");
		logger.info("페이지로부터 전달받은 데이터: {}", user.getUserid());
		logger.info("페이지로부터 전달받은 데이터: {}", user.getUserpw());
	}
	
	@RequestMapping(value = "/test3", method=RequestMethod.GET)
	public String test3() {
		return "test3";
	}
	
	@ResponseBody
	@RequestMapping(value="/fourth", method = RequestMethod.POST, produces = "application/test;charset=utf-8;")
	public void fourth(@RequestBody UserVO user) { //vo 자동 매핑 되려면 requestbody 필수
		logger.info("fourth 메서드 실행.");
		logger.info("페이지로부터 전달받은 데이터: {}", user.getUserid());
		logger.info("페이지로부터 전달받은 데이터: {}", user.getUserpw());
	}
	
	@ResponseBody
	@RequestMapping(value="/fifth", method = RequestMethod.POST)
	public UserVO fifth() {
		logger.info("fifth 메서드 실행.");
		UserVO result = new UserVO("asdf","1234");
		return result;
	}
}

package com.scit.web8.controller;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.scit.web8.controller.MemberController;
import com.scit.web8.service.MemberService;
import com.scit.web8.vo.MemberVo;

@Controller
@RequestMapping(value="/member")
public class MemberController {

	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Autowired
	private MemberService ms;
	
	@RequestMapping(value="/joinForm", method=RequestMethod.GET)
	public String joinForm() {
		
		return "member/joinForm";
	}
	
	@RequestMapping(value="/join", method=RequestMethod.POST)
	public String join(MemberVo member) {
		
		logger.info("회원 가입 {}", member);
		String page = ms.memberJoin(member);
		
		return page;
	}
	
	@RequestMapping(value="/joinFail", method=RequestMethod.GET)
	public String joinFail() {
		
		return "member/joinFail";
	}
	
	@RequestMapping(value="/listForm", method=RequestMethod.GET)
	public String listForm(Model model) {
		
		ArrayList<MemberVo> list = ms.listForm();
		
		model.addAttribute("list", list);

		return "member/listForm";
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.GET)
	public String delete(String member_id) {
		
		int cnt = ms.delete(member_id);
		
		if(cnt == 0) {
			System.out.println("삭제 실패");
		}
		
		return "redirect:listForm";
	}
	
	@RequestMapping(value="/search", method=RequestMethod.GET)
	public String search(String min, String max, Model model) {
		
		ArrayList<MemberVo> list = ms.memberSearch(min, max);
		
		model.addAttribute("list", list);
		model.addAttribute("min", min);
		model.addAttribute("max", max);
		
		return "member/listForm";
	}
}

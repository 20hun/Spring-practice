package com.scit.web5.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.scit.web5.service.MemberService;
import com.scit.web5.vo.MemberVO;

@Controller
public class MemberController {
	
	@Autowired //스프링 너무 좋아져서 안붙여도 됨, bean으로 등록되어 있어야만
	private MemberService memberService;
	
	@RequestMapping(value="/member/joinForm", method=RequestMethod.GET)
	public String joinForm() {
		System.out.println("회원 가입 폼 이동");
		
		return "member/joinForm";
	}
	
	@RequestMapping(value="/member/join", method = RequestMethod.POST)
	public String memberJoin(MemberVO member) {
		
		//bean으로 설정되어 있어서 의존성 주입 받음
		//MemberService ms = new MemberService();
		String page = memberService.memberJoin(member);
		return page;
	}
}

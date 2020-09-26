package com.scit.web6.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.scit.web6.service.MemberService;
import com.scit.web6.vo.MemberVo;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	@RequestMapping(value="/member/joinForm", method=RequestMethod.GET)
	public String joinForm() {
		
		
		return "member/joinForm";
	}
	
	@RequestMapping(value="/member/join", method=RequestMethod.POST)
	public String join(MemberVo member) {
		
		String page = memberService.memberJoin(member);
		
		System.out.println(member);
		
		return page;
	}
	
	@RequestMapping(value="/member/listForm", method=RequestMethod.GET)
	public String listForm(Model model) {
		
		ArrayList<MemberVo> av = memberService.list;
		
		model.addAttribute("av",av);
		
		return "member/listForm";
	}
	
	@RequestMapping(value="/member/delete", method=RequestMethod.GET)
	public String listForm(Model model, String id) {
		memberService.memberDelete(id);
		
		ArrayList<MemberVo> av = memberService.list;
		model.addAttribute("av", av);
		
		return "member/listForm";
	}
	
	@RequestMapping(value="/member/delete2", method=RequestMethod.GET)
	public String delete() {
		return "member/delete";
	}
	
	@RequestMapping(value="/member/delete3", method=RequestMethod.GET)
	public String delete(Model model, /*String id*/ MemberVo member) {
		System.out.println(member);
		System.out.println(member.getName());
		//memberService.memberDelete(id);
		memberService.memberDelete(member.getId());
		
		ArrayList<MemberVo> av = memberService.list;
		model.addAttribute("av", av);
		
		return "member/listForm";
	}
}

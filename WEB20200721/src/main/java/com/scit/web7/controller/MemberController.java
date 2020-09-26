package com.scit.web7.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.scit.web7.service.MemberService;
import com.scit.web7.vo.MemberVO;

@Controller
@RequestMapping(value="/member")
public class MemberController {
	
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Autowired
	private MemberService ms;
	
	@RequestMapping(value="/joinForm", method=RequestMethod.GET)
	public String joinForm() {
		
		logger.info("회원 가입 폼 이동");
		
		return "member/joinForm";
	}
	
	@RequestMapping(value="/join", method=RequestMethod.POST)
	public String join(MemberVO member) {
		
		logger.info("회원 가입 {}", member);
		
		String page = ms.memberJoin(member);
		
		return page;
	}
	
	@RequestMapping(value="/joinFail", method=RequestMethod.GET)
	public String joinFail() {

		return "member/joinFail";
	}
	
	@RequestMapping(value="/joinList", method=RequestMethod.GET)
	public String joinList(Model model, HttpSession session) {
		
		String page = "";
		
		String loginId = (String)session.getAttribute("loginId");
		if(loginId != null) {
			ArrayList<MemberVO> list = ms.joinList();
			model.addAttribute("list", list);
			page = "member/joinList";
		} else {
			page = "redirect:/member/loginForm";
		}
		return page; //forward 방식으로 가야 데이터 전달
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.GET)
	public String joinFail(String member_id) {
		
		String page = ms.deleteList(member_id);
		if(page == "redirect:/") {
			ms.memberLogout();
		}
		return page;
	}
	
	@RequestMapping(value = "/selectOne", method = RequestMethod.GET)
	public String memberSelectOne(String member_id, Model model) {
		
		MemberVO member = ms.memberSelectOne(member_id);
		
		model.addAttribute("member", member);
		
		return "member/memberInfo";
	}
	
	@RequestMapping(value = "/memberUpdateForm", method = RequestMethod.GET)
	public String memberUpdateForm(String member_id, Model model) {
		MemberVO member = ms.memberSelectOne(member_id);
		model.addAttribute("member", member);
		return "member/memberUpdateForm";
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String memberUpdate(MemberVO member) {
		ms.memberUpdate(member);
		
		return "redirect:joinList";
	}
	
	@RequestMapping(value = "/loginForm", method = RequestMethod.GET)
	public String memberLoginForm() {
		return "member/memberLoginForm";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String memberLogin(MemberVO member) {
		
		String page = ms.memberLogin(member);
		
		return page;
	}
	
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String memberLogout() {
		ms.memberLogout();
		return "redirect:/";
	}
	
	@ResponseBody
	@RequestMapping(value="/idCheck", method = RequestMethod.GET, produces = "application/test;charset=utf-8;")
	public String idCheck(String id) {
		String result = "사용할 수 있는 ID입니다.";
		
		ArrayList<MemberVO> list = ms.joinList();
		
		for(int i = 0; i< list.size(); i++) {
			if(id.equals(list.get(i).getMember_id())){
				result="사용 중인 ID입니다.";
				break;
			}
		}
		
		return result;
	}
}

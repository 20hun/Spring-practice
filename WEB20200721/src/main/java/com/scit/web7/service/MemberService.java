package com.scit.web7.service;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scit.web7.dao.MemberDAO;
import com.scit.web7.vo.MemberVO;

@Service
public class MemberService {
	
	@Autowired
	private MemberDAO dao;
	
	@Autowired
	private HttpSession session;
	
	public String memberJoin(MemberVO member) {
		int cnt = dao.memberJoin(member);	
		
		//for, if 등 비즈니스 로직 여기다 작성
		
		String page = "";
		if(cnt == 0) {
			page = "redirect:/member/joinFail"; //redirect:joinFail 상대주소도 가능 현재 주소창 ~/member/joinForm이니까
		}else {
			page = "redirect:/";
		}
		
		return page;
	}
	
	public ArrayList<MemberVO> joinList(){
		ArrayList<MemberVO> list = dao.joinList();
		return list;
		//return dao.joinList();
	}
	
	public String deleteList(String member_id) {

		int cnt = dao.deleteList(member_id);
		
		String page = "";
		
		if(cnt == 0) {
			page = "redirect:/member/joinFail";
		}else if(member_id.equals(session.getAttribute("loginId"))){
			page = "redirect:/";
		}else {
			page = "redirect:joinList";
		}
		
		return page;
	}
	
	public MemberVO memberSelectOne(String member_id) {
		
		MemberVO member = dao.memberSelectOne(member_id);
		
		return member;
	}
	
	public int memberUpdate(MemberVO member) {
		
		int cnt = dao.memberUpdate(member);
		
		return cnt;
	}
	
	public String memberLogin(MemberVO member) {
		MemberVO loginCheck = dao.memberSelectOne(member.getMember_id());
		
		//로그인 성공 여부에 따라 리턴될 값
		String page ="";
		
		//사용자는 id를 입력했지만 null값 받을 수도 있다
		if(loginCheck != null && loginCheck.getMember_pw().equals(member.getMember_pw())) {
			//로그인 성공
			//SessionScope가 필요한 상황 > HttpSession객체가 SessionScope
			session.setAttribute("loginId", member.getMember_id());
			page = "redirect:/";
			//세션에 데이터 저장(조작)하니까 리다이렉트
		} else {
			page = "redirect:/member/loginForm";
			//입력되었던 데이터 유지되니까 리다이렉트
			//로그인 실패
		}
		
		return page;
	}
	
	public void memberLogout() {
		//session에서 로그인정보를 삭제하는 기능
		session.removeAttribute("loginId");
	}
}

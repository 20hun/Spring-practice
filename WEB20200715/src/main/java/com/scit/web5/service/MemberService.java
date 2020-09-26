package com.scit.web5.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.scit.web5.vo.MemberVO;

@Service
public class MemberService {
	
	//DB의 역할 잠시 동안 대신해줄 list
	public ArrayList<MemberVO> list = new ArrayList<MemberVO>();
	
	public String memberJoin(MemberVO member) {
		
		//DAO에 member를 전달하는 문장으로 바뀔예정
		list.add(member);
		//DB로부터 돌려받은 값 이라고 가정
		int cnt = 1;
		
		for(MemberVO v : list) {
			System.out.println(v);
		}
		
		String page = "";
		
		if(cnt == 0) {
			page = "member/joinFail";
		}else {
			page = "member/joinComplete";
		}
		
		return page;
	}
}

package com.scit.web6.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.scit.web6.vo.MemberVo;

@Service
public class MemberService {
	public ArrayList<MemberVo> list = new ArrayList<MemberVo>();
	
	public String memberJoin(MemberVo member) {
		
		int cnt = 0;
		
		String page = "member/joinComplete";
		
		for(int i = 0; i<list.size(); i++) {
			if(member.getId().equals(list.get(i).getId())) {
				System.out.println("동일한 아이디 이미 있음");
				page = "member/joinFail";
				cnt++;
			}
		}
		
		if(cnt == 0) {
			list.add(member);
		}
		
		return page;
	}
	
	public void memberDelete(String id) {
		
		for(int i = 0; i<list.size(); i++) {
			if(list.get(i).getId().equals(id)) {
				list.remove(i);
			}
		}
	}
}

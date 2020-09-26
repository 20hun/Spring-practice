package com.scit.web8.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scit.web8.dao.MemberDAO;
import com.scit.web8.vo.MemberVo;

@Service
public class MemberService {
	
	@Autowired
	private MemberDAO dao;
	
	public String memberJoin(MemberVo member) {
		
		int cnt = dao.memberJoin(member);
		
		String page = "";
		
		if(cnt == 0) {
			page = "redirect:joinFail";
		}else {
			page = "redirect:/";
		}
		
		return page;
	}
	
	public ArrayList<MemberVo> listForm(){
		
		ArrayList<MemberVo> list = dao.listForm();
		
		return list;
	}
	
	public int delete(String member_id) {
		
		int cnt = dao.delete(member_id);
		
		return cnt;
	}
	
	public ArrayList<MemberVo> listForm2(String min, String max){
		
		ArrayList<MemberVo> list = dao.listForm();
		ArrayList<MemberVo> list2 = new ArrayList<MemberVo>();
		for(int i = 0; i<list.size(); i++) {
		if(Integer.parseInt(min)<=Integer.parseInt(list.get(i).getMember_birth()) && Integer.parseInt(list.get(i).getMember_birth())<=Integer.parseInt(max)) {
			list2.add(list.get(i));
		}
		}
		return list2;
	}
	
	public ArrayList<MemberVo> memberSearch(String min, String max){
		HashMap<String, String> map = new HashMap<String, String>();
		
		map.put("min", min);
		map.put("max", max);
		
		ArrayList<MemberVo> list = dao.search(map);
		
		return list;
	}
}

package com.scit.web8.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.scit.web8.vo.MemberVo;

@Repository
public class MemberDAO {
	
	@Autowired
	private SqlSession session;
	
	public int memberJoin(MemberVo member) {
		
		MemberMapper mapper = session.getMapper(MemberMapper.class);
		int cnt = 0;
		
		try {
			cnt = mapper.memberJoin(member);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return cnt;
	}
	
	public ArrayList<MemberVo> listForm() {
		
		MemberMapper mapper = session.getMapper(MemberMapper.class);

		ArrayList<MemberVo> list = null;
		
		try {
			list = mapper.listForm();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public int delete(String member_id) {
		
		MemberMapper mapper = session.getMapper(MemberMapper.class);
		int cnt = 0;
		
		try {
			cnt = mapper.delete(member_id);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return cnt;
	}
	
	public ArrayList<MemberVo> search(HashMap<String, String> map){
		
		MemberMapper mapper = session.getMapper(MemberMapper.class);

		ArrayList<MemberVo> list = null;
		
		try {
			list = mapper.search(map);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
}

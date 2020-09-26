package com.scit.web7.dao;

import java.util.ArrayList;

import com.scit.web7.vo.MemberVO;

public interface MemberMapper {

	public int memberJoin(MemberVO member);
	
	public ArrayList<MemberVO> joinList();
	
	public int deleteList(String member_id);
	
	public MemberVO memberSelectOne(String member_id);
	
	public int memberUpdate(MemberVO member);
}

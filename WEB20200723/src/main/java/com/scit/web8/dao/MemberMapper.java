package com.scit.web8.dao;

import java.util.ArrayList;
import java.util.HashMap;

import com.scit.web8.vo.MemberVo;

public interface MemberMapper {
	
	public int memberJoin(MemberVo member);
	
	public ArrayList<MemberVo> listForm();
	
	public int delete(String member_id);
	
	public ArrayList<MemberVo> search(HashMap<String, String> map);

}

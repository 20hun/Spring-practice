package com.test.housebook.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.housebook.vo.MoneybookVO;

@Repository
public class MoneybookDAO {
	
	@Autowired
	private SqlSession session;

	public ArrayList<MoneybookVO> bookList(HashMap<String, String> map) {
		
		MoneybookMapper mapper = session.getMapper(MoneybookMapper.class);
		
		ArrayList<MoneybookVO> list = null;
		
		try {
			list = mapper.bookList(map);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}

	public String inCheck(HashMap<String, String> map) {
		MoneybookMapper mapper = session.getMapper(MoneybookMapper.class);
		
		String result = "";
		
		try {
			result = mapper.inCheck(map);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}

	public String mmCheck(HashMap<String, String> map) {
		MoneybookMapper mapper = session.getMapper(MoneybookMapper.class);
		
		String result = "";
		
		try {
			result = mapper.mmCheck(map);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}

	public int insert(MoneybookVO mb) {
		MoneybookMapper mapper = session.getMapper(MoneybookMapper.class);
		
		int cnt = 0;
		
		try {
			cnt = mapper.insert(mb);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return cnt;
	}

	public int delete(int moneybook_no) {
		MoneybookMapper mapper = session.getMapper(MoneybookMapper.class);
		
		int cnt = 0;
		
		try {
			cnt = mapper.delete(moneybook_no);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return cnt;
		
	}

	public MoneybookVO bookUpdate(int moneybook_no) {
		MoneybookMapper mapper = session.getMapper(MoneybookMapper.class);
		
		MoneybookVO list = null;
		
		try {
			list = mapper.bookUpdate(moneybook_no);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}

	public int update(MoneybookVO mb) {
		
		MoneybookMapper mapper = session.getMapper(MoneybookMapper.class);
		
		int cnt = 0;
		
		try {
			cnt = mapper.update(mb);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return cnt;
	}

}

package com.test.housebook.service;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.housebook.dao.MoneybookDAO;
import com.test.housebook.vo.MoneybookVO;

@Service
public class MoneybookService {
	@Autowired
	private MoneybookDAO dao;
	
	@Autowired
	private HttpSession session;

	public ArrayList<MoneybookVO> bookList(String searchText, String searchType) {
		HashMap<String, String> map = new HashMap<>();
		map.put("searchText", searchText);
		map.put("searchType", searchType);
		map.put("loginId", (String)session.getAttribute("loginId"));
		
		ArrayList<MoneybookVO> list = dao.bookList(map);
		
		return list;
	}

	public String inCheck(String type) {
		HashMap<String, String> map = new HashMap<>();
		map.put("loginId", (String)session.getAttribute("loginId"));
		map.put("type", type);
		
		String result = dao.inCheck(map);
		return result;
	}

	public String mmCheck(String type) {
		HashMap<String, String> map = new HashMap<>();
		map.put("loginId", (String)session.getAttribute("loginId"));
		map.put("type", type);
		
		String result = dao.mmCheck(map);
		return result;
	}

	public String insert(MoneybookVO mb) {
		int cnt = 0;
		
		cnt = dao.insert(mb);
		
		String page = "";
		if(cnt == 0) {
			page = "redirect:bookInsert";
		} else {
			page = "redirect:myBook";
		}
		
		return page;
	}

	public void delete(int moneybook_no) {
		dao.delete(moneybook_no);
	}

	public MoneybookVO bookUpdate(int moneybook_no) {
		MoneybookVO list = dao.bookUpdate(moneybook_no);	
		
		return list;
	}

	public void update(MoneybookVO mb) {
		dao.update(mb);
	}

}

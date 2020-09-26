package com.scit.web7.service;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scit.web7.dao.BoardDAO;
import com.scit.web7.vo.BoardVO;
import com.scit.web7.vo.ReplyVO;

@Service
public class BoardService {
	
	@Autowired
	private BoardDAO dao;
	
	@Autowired
	private HttpSession session;
	
	public int boardWrite(BoardVO board) {
		
		//String member_id = (String)session.getAttribute~;
		
		board.setMember_id((String)session.getAttribute("loginId"));
		
		int cnt = dao.boardWrite(board);
		
		return cnt;
	}
	public BoardVO boardSelectOne(int board_no) {
		BoardVO board = dao.boardSelectOne(board_no);
		return board;
	}
	
	public int boardCount(String searchText, String searchType) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("searchText", searchText);
		map.put("searchType", searchType);	
		int cnt = dao.boardCount(map);
		return cnt;
	}
	
	public ArrayList<HashMap<String, Object>> boardList(String searchText, String searchType
			, int startRecord, int countPerPage){
		HashMap<String, Object> map = new HashMap<>();
		map.put("searchText", searchText);
		map.put("searchType", searchType);
		map.put("startRecord", startRecord);
		map.put("countPerPage", countPerPage);
		//ArrayList<HashMap<String, Object>> list = dao.boardList(map, startRecord, countPerPage);
		ArrayList<HashMap<String, Object>> list = dao.boardList(map);
		return list;
	}
	
	int j = 0;
	public HashMap<String, Object> boardRead(int board_no){
		if(j==0) {
			dao.updateHits(board_no);
		}
		HashMap<String, Object> map = dao.boardRead(board_no);
		return map;
	}
	
	public int boardDelete(int board_no) {
		int cnt = dao.boardDelete(board_no);
		return cnt;
	}
	
	public int boardUpdate(BoardVO board){
		String member_id = (String)session.getAttribute("loginId");
		board.setMember_id(member_id);
		int cnt = dao.boardUpdate(board);
		return cnt;
	}
	
	public void haha() {
		j++;
	}
	public void mama() {
		j--;
	}
	public ArrayList<ReplyVO> readReply(int board_no) {
		ArrayList<ReplyVO> list = dao.readReply(board_no);
		return list;
	}

}

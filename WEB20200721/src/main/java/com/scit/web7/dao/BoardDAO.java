package com.scit.web7.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.scit.web7.vo.BoardVO;
import com.scit.web7.vo.ReplyVO;

@Repository
public class BoardDAO {
	
	@Autowired
	private SqlSession session;
	
	public int boardWrite(BoardVO board) {
		BoardMapper mapper = session.getMapper(BoardMapper.class);
		
		int cnt = 0;
		
		try {
			cnt = mapper.boardWrite(board);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return cnt;
	}
	
	public int boardCount(HashMap<String, Object> map) {
		BoardMapper mapper = session.getMapper(BoardMapper.class);
		int cnt = 0;
		
		try {
			cnt = mapper.boardCount(map);
		}catch(Exception e){
			e.printStackTrace();
		}	
		return cnt;
	}
	
	public BoardVO boardSelectOne(int board_no) {
		BoardMapper mapper = session.getMapper(BoardMapper.class);
		BoardVO board = null;
		try {
			board = mapper.boardSelectOne(board_no);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return board;
	}
	
	public ArrayList<HashMap<String, Object>> boardList(HashMap<String, Object> map
			//, int startRecord, int countPerPage) {
			){
		BoardMapper mapper = session.getMapper(BoardMapper.class);
		
		ArrayList<HashMap<String, Object>> list = null;
		//페이징 처리에 사용할 객체
		RowBounds rb = new RowBounds((int)map.get("startRecord"), (int)map.get("countPerPage"));
		try {
			list = mapper.boardList(map, rb);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public void updateHits(int board_no) {
		BoardMapper mapper = session.getMapper(BoardMapper.class);
		
		try {
			mapper.updateHits(board_no);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public HashMap<String, Object> boardRead(int board_no){
		BoardMapper mapper = session.getMapper(BoardMapper.class);
		
		HashMap<String, Object> map = null;
		
		try {
			map = mapper.boardRead(board_no);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return map;
	}
	
	public int boardDelete(int board_no) {
		BoardMapper mapper = session.getMapper(BoardMapper.class);
		
		int cnt = 0;
		
		try {
			cnt = mapper.boardDelete(board_no);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return cnt;
	}
	
	public int boardUpdate(BoardVO board) {
		BoardMapper mapper = session.getMapper(BoardMapper.class);
		
		int cnt = 0;
		
		try {
			cnt = mapper.boardUpdate(board);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return cnt;
	}

	public ArrayList<ReplyVO> readReply(int board_no) {
		BoardMapper mapper = session.getMapper(BoardMapper.class);
		ArrayList<ReplyVO> list = null;
		
		try {
			list = mapper.readReply(board_no);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	

}

package com.scit.web7.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.RowBounds;

import com.scit.web7.vo.BoardVO;
import com.scit.web7.vo.ReplyVO;

public interface BoardMapper {
	public int boardWrite(BoardVO board);
	public ArrayList<HashMap<String, Object>> boardList(HashMap<String, Object> map, RowBounds rb);
	public void updateHits(int board_no);
	public HashMap<String, Object> boardRead(int board_no);
	public int boardDelete(int board_no);
	public int boardUpdate(BoardVO board);
	public BoardVO boardSelectOne(int board_no);
	public int boardCount(HashMap<String, Object> map);
//	public ArrayList<HashMap<String, Object>> searchBoard(HashMap<String, Object> map);
	public ArrayList<ReplyVO> readReply(int board_no);
}

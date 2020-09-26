package com.test.housebook.dao;

import java.util.ArrayList;
import java.util.HashMap;

import com.test.housebook.vo.MoneybookVO;

public interface MoneybookMapper {

	public ArrayList<MoneybookVO> bookList(HashMap<String, String> map);

	public String inCheck(HashMap<String, String> map);

	public String mmCheck(HashMap<String, String> map);

	public int insert(MoneybookVO mb);

	public int delete(int moneybook_no);

	public MoneybookVO bookUpdate(int moneybook_no);

	public int update(MoneybookVO mb);

}

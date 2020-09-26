package com.test.housebook.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.test.housebook.service.MoneybookService;
import com.test.housebook.vo.MoneybookVO;

@Controller
@RequestMapping(value="/moneybook")
public class MoneybookController {
	
	@Autowired
	private MoneybookService ms;
	
	@RequestMapping(value="/myBook", method=RequestMethod.GET)
	public String myBook(Model model,
			@RequestParam(value = "searchText", defaultValue = "") String searchText,
			@RequestParam(value = "searchType", defaultValue = "none") String searchType) {
		
		ArrayList<MoneybookVO> list = ms.bookList(searchText, searchType);
		
		ArrayList<String> list2 = new ArrayList<String>();
		for(int i = 0; i<list.size(); i++) {
		String str = Long.toString(list.get(i).getMoneybook_indate()).substring(0, 4)+
		"-"+Long.toString(list.get(i).getMoneybook_indate()).substring(4, 6)+
		"-"+Long.toString(list.get(i).getMoneybook_indate()).substring(6, 8);
		list2.add(str);
		}
		
		model.addAttribute("list", list);
		model.addAttribute("list2", list2);
		return "moneybook/myBook";
	}
	
	@ResponseBody
	@RequestMapping(value="/inCheck", method = RequestMethod.GET, produces = "application/test;charset=utf-8;")
	public String inCheck(String type) {
		
		String result = "";
		
		if(type.equals("총 수입 구하기")) {
			result = ms.inCheck("수입");
		} else {
			result = ms.inCheck("지출");
		}
		
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value="/mmCheck", method = RequestMethod.GET, produces = "application/test;charset=utf-8;")
	public String mmCheck(String type) {
		
		String result = "";
		
		if(type.equals("최소 금액 구하기")) {
			result = ms.mmCheck("min");
		} else {
			result = ms.mmCheck("max");
		}
		
		return result;
	}
	
	@RequestMapping(value="/bookInsert", method=RequestMethod.GET)
	public String bookInsert() {
		return "moneybook/bookInsert";
	}
	
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	public String insert(MoneybookVO mb) {
		
		System.out.println(mb);
		
		String page = "";
		page = ms.insert(mb);
		
		return page;
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.GET)
	public String delete(int moneybook_no) {
		
		ms.delete(moneybook_no);
		
		return "redirect:/moneybook/myBook";
	}
	
	@RequestMapping(value="/bookUpdate", method=RequestMethod.GET)
	public String bookUpdate(int moneybook_no, Model model) {
		
		MoneybookVO list = ms.bookUpdate(moneybook_no);
		
		model.addAttribute("list", list);
		
		return "moneybook/bookUpdate";
	}
	
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public String update(MoneybookVO mb) {
		
		ms.update(mb);
		
		return "redirect:/moneybook/myBook";
	}
}

package com.scit.web7.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.scit.web7.vo.ReplyVO;
import com.scit.web7.service.BoardService;
import com.scit.web7.util.FileService;
import com.scit.web7.util.PageNavigator;
import com.scit.web7.vo.BoardVO;

@Controller
@RequestMapping(value="/board")
public class BoardController {
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	@Autowired
	private BoardService ms;
								//sts c드라이브에 설치했으면 /(루트) = c:\
	private String uploadPath = "/boardfile";
	private final int COUNTERPAGE = 5;
	private final int PAGEPERGROUP = 5;
	
	@RequestMapping(value="/boardList", method=RequestMethod.GET)
	public String boardList(
			@RequestParam(value = "page", defaultValue="1") int page
			, @RequestParam(value = "searchText", defaultValue = "") String searchText
			, @RequestParam(value = "searchType", defaultValue = "none") String searchType
			, Model model) {
		
		//전체 글 개수 조회(검색을 했을때도 검색에 해당되는 글의 전체 개수도 조회  예로 전체 1000개, 검색 조건에 맞는 것 300개)
		int count = ms.boardCount(searchText, searchType);
		PageNavigator navi = new PageNavigator(COUNTERPAGE, PAGEPERGROUP, page, count);
		
		//글목록을 조회 한 후에 Model에 저장
		ArrayList<HashMap<String, Object>> list = ms.boardList(searchText, searchType, navi.getStartRecord(), navi.getCountPerPage());
		logger.info("list의 사이즈{}", list.size());
		model.addAttribute("list", list);
		model.addAttribute("navi",navi);
		model.addAttribute("searchText", searchText);
		model.addAttribute("searchType", searchType);
		return "board/boardList";
	}
	
	@RequestMapping(value="/boardWriteForm", method = RequestMethod.GET)
	public String boardWriteForm() {
		 
		return "board/boardWriteForm";
	}
	
	@RequestMapping(value="/boardWrite", method=RequestMethod.POST)
	public String boardWrite(BoardVO board, MultipartFile upload) {
		
		//upload > 파일이 있다면
		if(!upload.isEmpty()) {
			//파일 저장
			String savedfile = FileService.saveFile(upload, uploadPath);
			board.setSavedfile(savedfile);
			board.setOriginalfile(upload.getOriginalFilename());
		}
		
		ms.boardWrite(board);
		
		return "redirect:/board/boardList";
	}
	
	@ResponseBody
	@RequestMapping(value = "/readReply", method = RequestMethod.POST)
	public ArrayList<ReplyVO> readReply(int board_no) {
		logger.info("readReply 메서드 실행.");
		
		ArrayList<ReplyVO> list = ms.readReply(board_no);
		System.out.println(list);
		return list;
	}	
	
	@ResponseBody
	@RequestMapping(value="/sendMap", method = RequestMethod.POST)
	public void sendMap(@RequestBody HashMap<String, Object> map) {
		logger.info("sendMap 메서드 실행");
		logger.info("페이지로부터 전달받은 데이터: {}", map);
	}
	
	@RequestMapping(value="/boardRead", method=RequestMethod.GET)
	public String boardRead(Model model, int board_no) {
		
		HashMap<String, Object> map = ms.boardRead(board_no);
		model.addAttribute("map", map);
		return "board/boardRead";
	}
	
	@RequestMapping(value="/boardDelete", method=RequestMethod.GET)
	public String boardDelete(int board_no) {
		int cnt = ms.boardDelete(board_no);
		
		if(cnt == 0) {
			logger.info("삭제 실패 : {}", board_no);
		}else {
			logger.info("삭제 성공 : {}", board_no);
		}
		return "redirect:boardList";
	}
	
	@RequestMapping(value="/boardUpdateForm", method=RequestMethod.GET)
	public String boardUpdateForm(int board_no, Model model) {
		ms.haha();
		HashMap<String, Object> map = ms.boardRead(board_no);
		ms.mama();
		model.addAttribute("map", map);
		return "board/boardUpdateForm";
		
	}
	
	@RequestMapping(value="/boardUpdate", method=RequestMethod.POST)
	public String boardUpdate(BoardVO board) {
		int cnt = ms.boardUpdate(board);
		if(cnt==0) {
			logger.info("수정 실패 : {}",board);
		}else {
			logger.info("수정 성공 : {}",board);
		}
		return "redirect:boardList";
	}
	
	@RequestMapping(value = "/download", method = RequestMethod.GET)
	public String fileDownload(int board_no, HttpServletResponse response) {
		BoardVO board = ms.boardSelectOne(board_no);
		
		//원래의 파일명
		String originalfile = new String(board.getOriginalfile());
		try {
				//setHeader = 응답 객체에 하나의 설정을 추가했다 ,앞의 이름으로 ,뒤의 값을 설정	파일 이름이 영어로만 되어 있지 않아도 깨지지 않게 인코딩 해서 파일 이름으로 첨부파일 설정
			response.setHeader("Content-Disposition", " attachment;filename="+ URLEncoder.encode(originalfile, "UTF-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		//저장된 파일 경로
		String fullPath = uploadPath + "/" + board.getSavedfile();
		
		//서버의 파일을 읽을 입력 스트림과 클라이언트에게 전달할 출력스트림
		//어플리케이션 기준 들어오는게 input, 나가는게 output
		FileInputStream filein = null; //물리적인 공간의 파일을 webApplication으로 가져오기 위해
		ServletOutputStream fileout = null; //webApplicaion에서 파일객체를 사용자의 브라우저로 전달하기 위해
		
		try {
			filein = new FileInputStream(fullPath);
			fileout = response.getOutputStream();
			
			//Spring의 파일 관련 유틸
			FileCopyUtils.copy(filein, fileout);
			
			filein.close();
			fileout.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}

	/*
	 * @RequestMapping(value="/searchBoard", method = RequestMethod.GET) public
	 * String searchBoard(String searchText, String searchType, Model model) {
	 * ArrayList<HashMap<String, Object>> list = ms.searchBoard(searchText,
	 * searchType); model.addAttribute("list", list); return "board/boardList"; }
	 */
	
}

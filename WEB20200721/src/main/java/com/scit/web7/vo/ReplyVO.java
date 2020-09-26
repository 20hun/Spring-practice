package com.scit.web7.vo;

import lombok.Data;

@Data
public class ReplyVO {
	private int reply_no; //pk
	private int board_no; //fk
	private String writer; //fk
	private String indate;
	private String content;
	
}

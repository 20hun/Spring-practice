package com.scit.web6.vo;

import lombok.Data;

@Data
public class MemberVo {
	
	private String id;
	private String pw;
	private String name;
	//private String hobby;
	private String[] hobby;
	private String gender;
	private String info;
	private String[] hidden;
}

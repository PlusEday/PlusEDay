package org.eday.domain;

import java.util.List;

import lombok.Data;

@Data
public class Token {


	
	private UserInfo user;
	private boolean is_admin;
	private boolean is_vip;
	private String token;
	

	
}

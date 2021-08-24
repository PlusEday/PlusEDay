package org.eday.domain;

import lombok.Data;

@Data
public class MemberVO {
	
	private String member_id;
	private String member_name;
	private String email;
	private String pw;
	private String nickname;
	private int deleted_flag;

}

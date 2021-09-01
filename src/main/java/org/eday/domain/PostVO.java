package org.eday.domain;


import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class PostVO {

	private String post_id;
	private String detail;
	private Date regdate;
	private List<Post_photoVO> photo;
	private List<MemberVO> likedMember;
	private int reportCnt;
	private String member_id;
	
}

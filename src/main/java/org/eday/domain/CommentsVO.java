package org.eday.domain;

import lombok.Data;

@Data
public class CommentsVO {

	private String comment_id;
	private String detail;
	private String post_id;
	private String member_id;
	
}

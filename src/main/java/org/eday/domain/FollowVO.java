package org.eday.domain;

import lombok.Data;

@Data
public class FollowVO {
	
	private String member_id;
	private String following_id;
	private String follow_toggle;

}

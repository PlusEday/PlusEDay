package org.eday.domain;

import java.util.Date;

import lombok.Data;

@Data
public class SubmitVO {
	private String submit_id;
	private String challenge_id;
	private String member_id;
	private String detail;
	private Date regDate;
}

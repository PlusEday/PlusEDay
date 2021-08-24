package org.eday.domain;

import java.util.Date;

import lombok.Data;

@Data
public class ChallengeVO {
	private String challenge_id;
	private String member_id;
	private Date regDate;
	private Date startDate;
	private Date finishDate;
	private String detail;
}
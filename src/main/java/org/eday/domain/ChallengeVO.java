package org.eday.domain;

import java.util.Date;

import lombok.Data;

@Data
public class ChallengeVO {
	private String challenge_id;
	private String regDate;
	private String startDate;
	private String finishDate;
	private String detail;
	private String owner_id;
	private String subject_id; // subject
}

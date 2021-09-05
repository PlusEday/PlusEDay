package org.eday.domain;

import lombok.Data;

@Data
public class Challenge_ListDTO {
	private String challenge_id;
	private String regDate;
	private String startDate;
	private String finishDate;
	private String detail;
	private String owner_id;
	private String subject_id; // subject
	private String subject;
	private int category_id; // category
	private String subject_color;
	private int challenge_attendant;
	//private int challenge_like; 
}


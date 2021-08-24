package org.eday.domain;

import lombok.Data;

@Data
public class LevelVO {

	private String level_id;
	private String member_id;
	
	private int normal_posting_points;
	private int voluntary_posting_points;
	private int comment_points;
	private int challenge_points;
	private int normal_posting_like_points;
	private int voluntary_posting_like_points;
	private int challenge_like_points;
	private int checklist_points;
	private int reported_counts;
}

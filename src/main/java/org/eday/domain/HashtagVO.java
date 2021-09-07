package org.eday.domain;

import lombok.Data;

@Data
public class HashtagVO {

	private String hashtag_id;
	private String hashtag;
	private String calculable;
	private float CO2_cons;
	private float Energy_cons;
}

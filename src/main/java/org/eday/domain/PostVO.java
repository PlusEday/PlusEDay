package org.eday.domain;


import java.util.Date;

import lombok.Data;

@Data
public class PostVO {

	private String post_id;
	private String content;
	private Date regdate;
}

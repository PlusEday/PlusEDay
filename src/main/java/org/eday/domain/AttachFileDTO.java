package org.eday.domain;

import lombok.Data;

@Data
public class AttachFileDTO {

	private String fileName;
	private String uploadPath;
	private String uploadPathWithFileName;
	private String thumbnailName;
	private String thumbnailPath;
	private String uuid;
	private boolean image;
}

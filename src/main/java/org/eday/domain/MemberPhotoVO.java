package org.eday.domain;

import lombok.Data;

@Data
public class MemberPhotoVO {

	private String member_photo_id;
	private String member_id;
	private String mimetype;
	private byte[] data;
	private String created;
	private String original_name;
	
	
}

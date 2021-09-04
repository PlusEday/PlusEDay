package org.eday.service;

import org.eday.domain.MemberPhotoVO;

public interface MemberPhotoService {
	
	public int uploadProfile(MemberPhotoVO profile);
	public MemberPhotoVO getProfile(String member_id);
	
}

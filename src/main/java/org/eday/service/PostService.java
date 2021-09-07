package org.eday.service;

import org.eday.domain.PostVO;
import org.eday.domain.Post_photoVO;

public interface PostService {

	public int insertPost(PostVO post);
	
	public int insertPhoto(Post_photoVO photo);
	
	
}

package org.eday.service;

import java.util.List;

import org.eday.domain.HashtagVO;
import org.eday.domain.PostVO;
import org.eday.domain.Post_photoVO;

public interface PostService {

	public int insertPost(PostVO post);
	
	public int insertPhoto(Post_photoVO photo);
	
	public List<HashtagVO> searchHashtag(String keyword);
	
}

package org.eday.service;

import java.util.List;

import org.eday.domain.HashtagVO;
import org.eday.domain.PostVO;

public interface PostService {

	public int insertPost(PostVO post);
	public List<HashtagVO> searchHashtag(String keyword);
	
}

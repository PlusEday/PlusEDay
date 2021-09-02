package org.eday.service;

import org.eday.domain.PostVO;
import org.eday.domain.Post_likeVO;

public interface PostService {

	public int insertPost(PostVO post);
	
	public int postLike(Post_likeVO likeVO);
}

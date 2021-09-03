package org.eday.mapper;

import org.eday.domain.PostVO;
import org.eday.domain.Post_likeVO;

public interface PostMapper {
	
	public int insertPost(PostVO post);

	public String selectCheckLikePost(Post_likeVO postlike);
	
	public int insertPostLike(Post_likeVO postlike);
	
	public int updatePostLike(Post_likeVO postlike);
}

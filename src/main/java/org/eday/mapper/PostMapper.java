package org.eday.mapper;

import java.util.List;

import org.eday.domain.PostVO;
import org.eday.domain.Post_photoVO;

public interface PostMapper {
	
	public int insertPost(PostVO post);
	
	public int insertPhoto(Post_photoVO photo);
	
	public void deletePhoto(String photo_name);
	
	public List<Post_photoVO> findByPostId(String post_id);

}

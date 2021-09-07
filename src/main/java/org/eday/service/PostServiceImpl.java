package org.eday.service;

import org.eday.domain.PostVO;
import org.eday.domain.Post_photoVO;
import org.eday.mapper.PostMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
@AllArgsConstructor
public class PostServiceImpl implements PostService {
	
	@Setter(onMethod_=@Autowired)
	private PostMapper mapper;

	@Override
	public int insertPost(PostVO post) {
		
		log.info("InsertPost.......!!!" + post);
		
		return mapper.insertPost(post);
	}
	
	@Override
	public int insertPhoto(Post_photoVO photo) {
		
		log.info("Insert Post Photo-----!!!!");
		
		return mapper.insertPhoto(photo);
		
	}


}

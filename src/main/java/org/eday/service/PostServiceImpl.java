package org.eday.service;

import org.eday.domain.PostVO;
import org.eday.mapper.PostMapper;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
@AllArgsConstructor
public class PostServiceImpl implements PostService {
	
	private PostMapper mapper;

	@Override
	public int insertPost(PostVO post) {
		
		log.info("InsertPost.......!!!" + post);
		
		return mapper.insertPost(post);
	}

}

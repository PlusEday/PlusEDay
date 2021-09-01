package org.eday.mapper;

import org.eday.domain.PostVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes={ org.eday.config.RootConfig.class, org.eday.config.SecurityConfig.class})
@Log4j
public class PostMapperTests {

	@Setter(onMethod_=@Autowired)
	private PostMapper mapper;
	
	@Test
	public void testInsertPost(){
		
		PostVO post = new PostVO();
		
		post.setDetail("오늘은 텀블러에 음료를 사먹었다.");
		post.setMember_id("1");
		
		mapper.insertPost(post);
	}
}

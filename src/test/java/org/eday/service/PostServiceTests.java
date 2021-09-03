package org.eday.service;

import static org.junit.Assert.assertNotNull;

import org.eday.domain.PostVO;
import org.eday.domain.Post_likeVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@Log4j
@ContextConfiguration(classes={ org.eday.config.RootConfig.class, org.eday.config.SecurityConfig.class})
@WebAppConfiguration
public class PostServiceTests {

	@Setter(onMethod_=@Autowired)
	private PostService service;
	
//	@Test
//	public void testPostService(){
//		
//		log.info(service);
//		assertNotNull(service);
//	}
	
	@Test
	public void testInsertPost(){
		
		PostVO post = new PostVO();
		post.setDetail("오늘은 자전거를 타고 퇴근했다.");
		post.setMember_id("2");
		
		service.insertPost(post);
		
		log.info("포스팅 된 게시물:" + post);
	}
	
	@Test
	public void testpostLike(){
		
		/* 1. 좋아요를 누른적이 없는 경우
		 * Post_likeVO vo = new Post_likeVO();
		vo.setMember_id("3");
		vo.setPost_id("2");
		log.info(service.postLike(vo));*/
		
		/* 2. 좋아요가 되어있는 경우 
		 * Post_likeVO vo = new Post_likeVO();
		vo.setMember_id("2");
		vo.setPost_id("2");
		vo.setLike_toggle("y");
		log.info(service.postLike(vo));*/
		
		// 3. 좋아요가 취소되어있는 경우
		Post_likeVO vo = new Post_likeVO();
		vo.setMember_id("2");
		vo.setPost_id("2");
		vo.setLike_toggle("n");
		log.info(service.postLike(vo));
	} // 좋아요 테스트
}

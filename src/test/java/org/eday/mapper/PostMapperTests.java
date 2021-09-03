package org.eday.mapper;

import org.eday.domain.PostVO;
import org.eday.domain.Post_likeVO;
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
	
	@Test
	public void testselectCheckLikePost(){
		Post_likeVO likevo = new Post_likeVO();
		likevo.setMember_id("2");
		likevo.setPost_id("2");
		String check_like = mapper.selectCheckLikePost(likevo);
		log.info("좋아요 여부 : " + check_like);
	} // 좋아요 눌렀는지 여부 체크 테스트
	
	@Test
	public void testinsertPostLike() {
		Post_likeVO vo = new Post_likeVO();
		vo.setMember_id("4");
		vo.setPost_id("2");
		log.info(mapper.insertPostLike(vo));
	} // 좋아요 테이블에 넣기
	
	@Test
	public void testupdatePostLike() {
		Post_likeVO vo = new Post_likeVO();
		vo.setMember_id("4");
		vo.setPost_id("2");
		vo.setLike_toggle("n");
		log.info(mapper.updatePostLike(vo));
	} // 좋아요 업데이트
}

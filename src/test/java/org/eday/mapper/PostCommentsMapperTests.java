package org.eday.mapper;

import org.eday.domain.CommentsVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {org.eday.config.RootConfig.class, org.eday.config.SecurityConfig.class})
public class PostCommentsMapperTests {
	
	@Setter(onMethod_ = @Autowired)
	private PostCommentMapper mapper;
	
	/*@Test
	public void insertCommentTest() {
		CommentsVO vo = new CommentsVO();
		vo.setDetail("댓글 1등!!");
		vo.setMember_id("2");
		vo.setPost_id("2");
		log.info(mapper.insertComment(vo));
	}*/
	
	/*@Test
	public void readCommentTest() {
		log.info(mapper.readComment("2"));
	}*/
	
	/*@Test
	public void updateCommentTest() {
		CommentsVO vo = new CommentsVO();
		vo.setComment_id("1");
		vo.setDetail("댓글 수정합니다.");
		vo.setMember_id("2");
		log.info(mapper.updateComment(vo));
	}*/
	
	/*@Test
	public void deleteCommentsTest(){
		CommentsVO vo = new CommentsVO();
		vo.setComment_id("1");
		vo.setMember_id("2");
		log.info(mapper.deleteComment(vo));
	}*/
}

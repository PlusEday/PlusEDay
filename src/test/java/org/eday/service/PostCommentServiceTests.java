package org.eday.service;

import org.eday.domain.CommentsVO;
import org.eday.mapper.PostCommentMapper;
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
public class PostCommentServiceTests {
	
	@Setter(onMethod_ = @Autowired)
	private PostCommentService service;
	
/*	@Test
	public void writeCommentTest() {
		CommentsVO vo = new CommentsVO();
		vo.setDetail("댓글입니다.. 다들 쓰레기 버리지마세요");
		vo.setMember_id("1");
		vo.setPost_id("2");
		log.info(service.writeComment(vo));
	}*/
	
	/*@Test
	public void modifyCommentTest(){
		CommentsVO vo = service.getComment("3");
		vo.setDetail("수정된 댓글입니다.. 다들 쓰레기 버리지마세요");
		log.info(service.modifyComment(vo));
	}*/
	
	/*@Test
	public void getCommentTest() {
		log.info(service.getComment("2"));
	}*/
	
	/*@Test
	public void removeCommentTest(){
		CommentsVO vo = service.getComment("2");
		log.info(service.removeComment(vo));
	}*/
}

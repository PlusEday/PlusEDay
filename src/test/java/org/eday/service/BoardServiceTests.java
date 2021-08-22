package org.eday.service;

import org.eday.domain.BoardVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {org.eday.config.RootConfig.class})
@Log4j
public class BoardServiceTests {
	@Setter(onMethod_ = @Autowired)
	private BoardService service;
	
	/*@Test
	public void testRegister() {
		BoardVO board = new BoardVO();
		board.setTitle("hello wolrd2");
		board.setContent("wow");
		board.setWriter("fg");
		service.register(board);
	}*/
	
	@Test
	public void testRead() {
		log.info(service.get(300L));
	}
}

package org.eday.mapper;
import org.eday.domain.BoardVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.beans.factory.annotation.Autowired;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {org.eday.config.RootConfig.class})
public class BoardMapperTests {
	@Setter(onMethod_ = {@Autowired})
	private BoardMapper mapper;
	
	/*@Test
	public void testInsert(){
		BoardVO board = new BoardVO();
		board.setTitle("hello world");
		board.setContent("³»¿ë");
		board.setWriter("¾È³ç");
		mapper.insert(board);
	}*/
	
	@Test
	public void testRead() {
		log.info(mapper.read(300L));
	}
}

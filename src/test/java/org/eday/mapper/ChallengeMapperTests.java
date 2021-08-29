package org.eday.mapper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.eday.domain.ChallengeVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {org.eday.config.RootConfig.class})
public class ChallengeMapperTests {
	
	@Setter(onMethod_ = {@Autowired})
	private ChallengeMapper mapper;
	
	@Test
	public void insertChallenge() throws ParseException {
		ChallengeVO challenge = new ChallengeVO();
		challenge.setStartDate("2021-08-26");
		challenge.setFinishDate("2021-09-26");
		challenge.setDetail("텀블러 사용할 사람 모여라!");
		challenge.setOwner_id("1");
		challenge.setSubject_id("3");
		mapper.insertChallenge(challenge);
	}
	/*@Test
	public void getChallengListTests() {
		List<ChallengeVO> list = mapper.getChallengList("1");
		list.forEach(challenge -> log.info(challenge));
	}*/
}

package org.eday.service;

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
@ContextConfiguration(classes = {org.eday.config.RootConfig.class, org.eday.config.SecurityConfig.class})
public class ChallengeServiceTests {
	
	@Setter(onMethod_ = @Autowired)
	private ChallengeService service;
	
	@Test
	public void insertChallengeTest(){
		ChallengeVO challenge = new ChallengeVO();
		challenge.setDetail("제발 텀블러만 사용합시다!");
		challenge.setStartDate("2021-12-11");
		challenge.setFinishDate("2021-12-25");
		challenge.setOwner_id("4");
		challenge.setSubject_id("3");
		service.insertChallenge(challenge);
	} // 챌린지 생성 서비스 테스트
	
	@Test
	public void getChallengeTest() {
		log.info(service.getChallenge("35"));
	} // 챌린지 글 가져오기 서비스 테스트 
	
	@Test
	public void updateChallengeTest(){
		ChallengeVO challenge = service.getChallenge("37");
		challenge.setDetail("[수정2] 일회용컵 대신 텀플러 사용하는 사람들의 모임!");
		log.info(service.updateChallenge(challenge));
	} // 챌린지 정보 수정 서비스 테스트
}

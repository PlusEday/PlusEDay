package org.eday.mapper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.eday.domain.ChallengeMemberVO;
import org.eday.domain.ChallengeVO;
import org.eday.domain.Challenge_ListDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {org.eday.config.RootConfig.class , org.eday.config.SecurityConfig.class})
public class ChallengeMapperTests {
	
	@Setter(onMethod_ = @Autowired)
	private ChallengeMapper mapper;
	
	/*@Test
	public void insertChallengeTest() {
		ChallengeVO challenge = new ChallengeVO();
		challenge.setDetail("크리스마스까지 일회용컵 대신 텀블러를 사용합시다!");
		challenge.setStartDate("2021-10-10");
		challenge.setFinishDate("2021-12-25");
		challenge.setOwner_id("1");
		challenge.setSubject_id("3");
		challenge.setSubject("챌린지!");
		log.info("insert challenge. . . . . .");
		mapper.create(challenge);
	}*/ // 챌린지 생성 테스트
	
	/*@Test
	public void insertChallengeMemberTest() {
		ChallengeMemberVO member = new ChallengeMemberVO();
		member.setChallenge_id("31");
		member.setMember_id("1");
		log.info("insert challenge member. . . . . .");
		mapper.createChallengeMember(member);
	}*/ // 챌린지 생성 후 멤버 추가 테스트
	
	/*@Test 
	public void getChallengeTest() {
		ChallengeVO challenge = mapper.readChallenge("31");
		log.info(challenge);
	} // 챌린지 한개 정보 가져오기 테스트
	
	@Test
	public void updateChallengeTest() {
		ChallengeVO challenge = new ChallengeVO();
		challenge.setChallenge_id("31");
		challenge.setRegDate("2021-08-26");
		challenge.setStartDate("2021-08-26");
		challenge.setFinishDate("2021-10-27");
		challenge.setOwner_id("1");
		challenge.setSubject_id("3");
		challenge.setDetail("두달간 일회용컵 대신 텀블러를 사용합시다!");
		log.info("update challenge. . . . . .");
		mapper.update(challenge);
	} // 챌린지 정보 수정 테스트
	
	@Test
	public void countChallengeMemberTest(){
		log.info("결과 : " + mapper.countChallengeMember("37"));
	}*/
	
	@Test
	public void getIngChallengeListTest() {
		List<Challenge_ListDTO> lists = mapper.getIngChallengeList();
		lists.forEach(challenge->log.info(challenge));
	}
}

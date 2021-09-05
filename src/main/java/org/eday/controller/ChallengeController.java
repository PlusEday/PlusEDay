package org.eday.controller;

import java.util.Map;

import org.eday.domain.ChallengeMemberVO;
import org.eday.domain.ChallengeVO;
import org.eday.service.ChallengeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@RequestMapping("/challenge")
@RestController
@AllArgsConstructor
public class ChallengeController {
	
	private ChallengeService challengeservice;
	
	@PostMapping(value="/creteChallenge",
			consumes="application/json",
			produces={MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> create(@RequestBody ChallengeVO challenge) {
		int insertCount = challengeservice.insertChallenge(challenge);
		return insertCount == 1 ? new ResponseEntity<>("success", HttpStatus.OK) : 
			new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	} // 챌린지 생성 API
	
	
	@PostMapping(value="/updateChallenge",
			consumes="application/json",
			produces={MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> update(@RequestBody ChallengeVO challenge) {
		int updateCount = challengeservice.updateChallenge(challenge);
		log.info(updateCount);
		return updateCount == 1 ? new ResponseEntity<>("success", HttpStatus.OK) :
			new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	} // 챌린지 수정 API
	
	@PostMapping(value="/getChallenge",
			consumes="application/json",
			produces="application/json")
	public ResponseEntity<ChallengeVO> get(@RequestBody Map<String, String> param){
		String challenge_id = param.get("challenge_id");
		log.info(challenge_id);
		return challengeservice.getChallenge(challenge_id) != null 
				? new ResponseEntity<>(challengeservice.getChallenge(challenge_id), HttpStatus.OK):
					new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	} // 챌린지 1개 정보 가져오는 API
	
	@PostMapping(value="/joinChallenge",
			consumes="application/json",
			produces={MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> join(@RequestBody Map<String, String> param) {
		String challenge_id = param.get("challenge_id");
		String member_id = param.get("member_id");
		ChallengeMemberVO vo = new ChallengeMemberVO();
		vo.setChallenge_id(challenge_id);
		vo.setMember_id(member_id);
		return challengeservice.joinChallenge(vo) == 1 ? 
				new ResponseEntity<>("success", HttpStatus.OK) :
					new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	} // 챌린지 참여
}

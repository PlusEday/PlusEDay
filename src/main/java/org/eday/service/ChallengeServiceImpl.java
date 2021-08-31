package org.eday.service;

import org.eday.domain.ChallengeMemberVO;
import org.eday.domain.ChallengeVO;
import org.eday.mapper.ChallengeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@AllArgsConstructor
public class ChallengeServiceImpl implements ChallengeService {

	@Setter(onMethod_ = @Autowired)
	private ChallengeMapper mapper;
	
	@Override
	@Transactional
	public int insertChallenge(ChallengeVO challenge) {
		log.info("insert Challenge Service. . . . . . ");
		mapper.create(challenge);
		ChallengeMemberVO member = new ChallengeMemberVO();
		member.setChallenge_id(challenge.getChallenge_id());
		member.setMember_id(challenge.getOwner_id());
		return mapper.createChallengeMember(member);
	}

	@Override
	public ChallengeVO getChallenge(String challenge_id) {
		log.info("get Challenge Service. . . . . . ");
		ChallengeVO challenge = mapper.readChallenge(challenge_id);
		log.info("에러발생지점 : " + challenge);
		challenge.setRegDate(challenge.getRegDate().substring(0, 10));
		challenge.setStartDate(challenge.getStartDate().substring(0, 10));
		challenge.setFinishDate(challenge.getFinishDate().substring(0, 10));
		return challenge;
	}

	@Override
	public int updateChallenge(ChallengeVO challenge) {
		log.info("update Challenge Service. . . . . .");
		return mapper.update(challenge);
	}

}

package org.eday.service;

import org.eday.domain.ChallengeMemberVO;
import org.eday.domain.ChallengeVO;

public interface ChallengeService {
	public int insertChallenge(ChallengeVO challenge); // 챌린지 생성
	public ChallengeVO getChallenge(String challenge_id); // 1개 챌린지 정보 가져오기
	public int updateChallenge(ChallengeVO challenge); // 챌린지 정보 수정
	public int joinChallenge(ChallengeMemberVO member);
}

package org.eday.mapper;

import java.util.List;

import org.eday.domain.ChallengeVO;

public interface ChallengeMapper {
	// 챌린지 생성
	public void insertChallenge(ChallengeVO challenge);
	
	// 챌린지 목록 조회
	public List<ChallengeVO> getChallengList(String category);
	
}

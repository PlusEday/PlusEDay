package org.eday.mapper;

import java.util.List;

import org.eday.domain.ChallengeMemberVO;
import org.eday.domain.ChallengeVO;

public interface ChallengeMapper {
	// 챌린지 생성
	public int create(ChallengeVO challenge);
	
	// 챌린지 생성과 동시에 챌린지 멤버에 추가 & 챌린지 신청에도 사용! 
	public int createChallengeMember(ChallengeMemberVO member);
	
	// 챌린지 1개 조회
	public ChallengeVO readChallenge(String challenge_id);
	
	// 챌린지 수정
	public int update(ChallengeVO challenge);
	
	// 도전 가능한 챌린지 목록 조회 : 현재날짜랑 비교해서/시작날짜가 현재날짜 이후인 챌린지
	public List<ChallengeVO> getChallengeList(String category);
	
	// 현재 진행중인 챌린지 목록 조회 : 현재날짜랑 비교
	public List<ChallengeVO> getIngChallengeList();
	
	// 챌린지 멤버 수 가져오기
	public int countChallengeMember(String challenge_id);
	
	// 도전중인 챌린지 목록 조회 : 시작날짜가 
}

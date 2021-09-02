package org.eday.mapper;

import java.util.List;

import org.eday.domain.FollowVO;
import org.eday.domain.MemberVO;
import org.eday.domain.UserInfo;

public interface FollowMapper {

	public int initFollow(FollowVO follow);
	public List<MemberVO> getFollowings(String member_id);
	public List<MemberVO> getFollowers(String member_id);
	public int updateFollow(FollowVO follow);
	public String checkFollow(FollowVO follow);
}

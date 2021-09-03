package org.eday.service;

import java.util.List;

import org.eday.domain.FollowVO;
import org.eday.domain.UserInfo;

public interface FollowService {

	public List<UserInfo> getFollowings(String member_id);
	public List<UserInfo> getFollowers(String member_id);
	public int follow(FollowVO follow);
	
}

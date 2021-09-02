package org.eday.service;

import java.util.ArrayList;
import java.util.List;

import org.eday.domain.FollowVO;
import org.eday.domain.MemberVO;
import org.eday.domain.UserInfo;
import org.eday.mapper.FollowMapper;
import org.eday.mapper.MemberMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@AllArgsConstructor
@Log4j
@Service
public class FollowServiceImpl implements FollowService{

	private FollowMapper mapper;

	@Override
	public List<UserInfo> getFollowings(String member_id) {
		List<MemberVO> mList= mapper.getFollowings(member_id);

		List<UserInfo> list = new ArrayList<UserInfo>();
		
		for(int i=0;i<mList.size();i++){
			UserInfo u = new UserInfo(mList.get(i));
				list.add(u);
		}
		return list;
	}

	@Override
	public List<UserInfo> getFollowers(String member_id) {
		List<MemberVO> mList= mapper.getFollowers(member_id);

		List<UserInfo> list = new ArrayList<UserInfo>();
		
		for(int i=0;i<mList.size();i++){
			UserInfo u = new UserInfo(mList.get(i));
				list.add(u);
		}
		return list;
	}

	@Override
	public int follow(FollowVO follow) {
		int re=0;
		String isFollowing = mapper.checkFollow(follow);
		
		log.info(isFollowing);
		if(isFollowing.equals("y")){
			log.info("맞다");
		re+=mapper.updateFollow(follow);
		}else{
		re+=mapper.initFollow(follow);
		}
		
		return re;
 	}

	
	
	
}

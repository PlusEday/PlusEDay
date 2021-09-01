package org.eday.domain;


import java.util.List;
import lombok.Data;


@Data
public class UserInfo{
	
	private String email;
	private String name;
	private String nickname;
	private LevelVO level;
	private List<FollowVO> followList;
	private BadgeVO badge;
	
	public UserInfo(){};
	
	public UserInfo(MemberVO member){
		this.email=member.getEmail();
		this.name=member.getMember_name();
		this.nickname=member.getNickname();
		this.level=member.getLevel();
		this.followList=member.getFollowList();
		this.badge=member.getBadge();
	}	
}

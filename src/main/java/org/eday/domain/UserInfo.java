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
	private String badge;
	private String member_id;
	private String thmbnail_name;
	private String thmbnail_path;
	
	
	public UserInfo(){};
	
	public UserInfo(MemberVO member){
		this.email=member.getEmail();
		this.name=member.getMember_name();
		this.nickname=member.getNickname();
		this.level=member.getLevel();
		this.followList=member.getFollowList();
		this.badge=member.getBadge_title();
		this.member_id=member.getMember_id();
		this.thmbnail_name=member.getPhoto_name();
		this.thmbnail_path=member.getUpload_path();
	}	
}

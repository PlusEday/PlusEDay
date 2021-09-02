package org.eday.domain;

import java.util.List;

import lombok.Data;

@Data
public class MemberVO {
	
	private String member_id;
	private String member_name;
	private String email;
	private String pw;
	private String nickname;
	private int deleted_flag;
	
	private LevelVO level;
	private List<FollowVO> followList;
	
	private String auth;
	private List<AuthVO> authList;
	
	private String photo_name;
	private String upload_path;
	
	private String badge_id;
	private String badge_title;
	
}

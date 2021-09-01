package org.eday.mapper;

import org.eday.domain.AuthVO;
import org.eday.domain.MemberVO;

public interface MemberMapper {
	
	public int signUp(MemberVO member);
	
	public MemberVO read(String username);
	
	public int insertAuth(AuthVO  auth);
	
	public MemberVO loggedIn(String email);
}

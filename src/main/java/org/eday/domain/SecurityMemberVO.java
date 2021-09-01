package org.eday.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import lombok.Data;

@Data
public class SecurityMemberVO extends User {
	private static final long serialVersionUID = 1L;
	
	public SecurityMemberVO(MemberVO member) {
		super(member.getEmail(), member.getPw(), makeGrantedAuthority(member.getAuthList()));
	}
	
	public SecurityMemberVO(String username, String password,
			Collection<? extends GrantedAuthority> authorities) {
			super(username, password, authorities);
		}
	
	private static List<GrantedAuthority> makeGrantedAuthority(List<AuthVO> auths){
		List<GrantedAuthority> list = new ArrayList<>();
		auths.forEach(auth -> list.add(new SimpleGrantedAuthority(auth.getAuth())));
		return list;
	}
}

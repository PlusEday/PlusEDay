package org.eday.service;

import org.eday.domain.AuthVO;
import org.eday.domain.MemberVO;
import org.eday.mapper.MemberMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@AllArgsConstructor
@Log4j
@Service
public class MemberServiceImpl implements MemberService{

	private MemberMapper mapper;
	private PasswordEncoder passwordEncoder;
	
	@Override
	public int insertMember(MemberVO member) {
		
		member.setPw(passwordEncoder.encode(member.getPw()));
		AuthVO auth = new AuthVO();
		auth.setEmail(member.getEmail());
		
		System.out.println(member.getPw());
		
		mapper.signUp(member);
		return mapper.insertAuth(auth);
	}

	@Override
	public MemberVO read(String email) {

		return mapper.read(email);
	}
	
	

}

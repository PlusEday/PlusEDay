package org.eday.service;

import org.eday.domain.MemberPhotoVO;
import org.eday.mapper.MemberMapper;
import org.eday.mapper.MemberPhotoMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@AllArgsConstructor
@Log4j
@Service
public class MemberPhotoServiceImpl implements MemberPhotoService{

	private MemberPhotoMapper mapper;
	
	@Override
	public int uploadProfile(MemberPhotoVO profile) {

		return mapper.uploadProfile(profile);
	}

}

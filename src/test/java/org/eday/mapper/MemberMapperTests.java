package org.eday.mapper;

import org.eday.domain.MemberVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes={ org.eday.config.RootConfig.class, org.eday.config.SecurityConfig.class})
@Log4j
public class MemberMapperTests {
	
	@Setter(onMethod_= @Autowired)
	private MemberMapper mapper;
	
//	@Test
//	public void testSignUp(){
//		MemberVO member = new MemberVO();
//		member.setEmail("yoon@gg.com");
//		member.setMember_name("윤혜경");
//		member.setPw("11112");
//		member.setNickname("윤");
//		mapper.signUp(member);
//	
//	}
	
	@Test
	public void testLogin(){
		String id="beom1843@naver.com";
		MemberVO member=mapper.read("yoon@gmail.com");
		
		log.info(member);
	}
	
}

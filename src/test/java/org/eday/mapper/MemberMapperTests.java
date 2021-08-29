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
	
	@Test
	public void testSignUp(){
		MemberVO member = new MemberVO();
		member.setEmail("beom1843@naver.com");
		member.setMember_name("좀여범");
		member.setPw("1111");
		member.setNickname("뭉버미");
		mapper.signUp(member);
	
	}
	
	
	
}

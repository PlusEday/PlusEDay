package org.eday.service;

import org.eday.domain.MemberVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@Log4j
@ContextConfiguration(classes={ org.eday.config.RootConfig.class, org.eday.config.SecurityConfig.class})
@WebAppConfiguration
public class MemberServiceTests {

	@Setter(onMethod_={@Autowired})
	private MemberService service;
	
	@Test
	public void testInsert(){
		MemberVO member = new MemberVO();
		member.setEmail("beom8990@naver.com");
		member.setMember_name("조묭범");
		member.setPw("1111");
		member.setNickname("버미범");
		service.insertMember(member);
	}
	
}

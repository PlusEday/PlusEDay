package org.eday.service;

import org.eday.domain.MemberVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
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
		member.setEmail("cho@gmail.com");
		member.setMember_name("조은범");
		member.setPw("1111");
		member.setNickname("은버미");
		service.insertMember(member);
	}
	
//	@Test
//	public void testRead(){
//		
//		MemberVO mem =service.read("nam@gmail.com");
//		if(mem != null){
//			System.out.println("성공");
//		}else{
//			System.out.println("실패");
//		}
//		log.info(mem);
//	}
	
	
//	@Setter(onMethod_={@Autowired})
//	private CustomUserDetailService logService;
//	@Autowired
//	private BCryptPasswordEncoder passwordEncoder;
//
//	@Test
//	public void testLogin(){
//		String id="nam@gmail.com";
//		String pw = "1111";
//		MemberVO member = new MemberVO();
//		member.setEmail(id);
//		member.setPw(pw);
//		System.out.println(member.getPw());
//		
//		String dbPw=logService.loadUserByUsername(id).getPassword();
//		
//		
//		System.out.println(dbPw);
//		if(passwordEncoder.matches(pw, dbPw)){
//			System.out.println("행복");
//		}else{
//			System.out.println("슬픔");
//		}
//
//	}
}

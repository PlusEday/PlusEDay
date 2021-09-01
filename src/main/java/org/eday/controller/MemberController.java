package org.eday.controller;
import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eday.domain.AuthVO;
import org.eday.domain.MemberVO;
import org.eday.domain.Token;
import org.eday.domain.UserInfo;
import org.eday.service.CustomUserDetailService;
import org.eday.service.MemberService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@RequestMapping("/*")
@RestController
@Log4j
@AllArgsConstructor
public class MemberController {
	
	private MemberService memberService;
	private CustomUserDetailService service;
	
	private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
	private PasswordEncoder passwordEncoder;
	
	@PostMapping(value="/logIn",
			consumes="application/json",
			produces={MediaType.APPLICATION_JSON_UTF8_VALUE,
					MediaType.APPLICATION_JSON_UTF8_VALUE})
		public ResponseEntity<Token> logIn(@RequestBody MemberVO member){
		String failReason="";
		boolean isAdmin =false;
		boolean isVip= false;
		MemberVO m = new MemberVO();
		
	//로그인시 받은 이메일, 비밀번호 가져오기, 로그인 실패시 사유를 담을 String
		String username = member.getEmail();
		String pw = member.getPw();

		System.out.println("이메일"+username);
		System.out.println("비번"+pw);
		
	//받은 이메일 정보와 일치하는 Member의 pw를 받아옴
		String dbPw = service.loadUserByUsername(username).getPassword();
	//아이디 null 체크, 비밀번호 비교 체크
		if(dbPw==null){
			failReason="ID not found";
		}else{
			System.out.println(dbPw);
			if(encoder.matches(pw, dbPw)){
				failReason="Success";
				//계정정보가 확인되고 토큰 생성
				
				 m = memberService.read(username);
				
				//isAdmin, isVip 체크
				List<AuthVO> aList= m.getAuthList();

				for(int i =0; i<aList.size();i++){
					if(aList.get(i).getAuth()=="ROLE_ADMIN"){
						isAdmin = true;
					}
					if(aList.get(i).getAuth()=="ROLE_VIP"){
						isVip=true;
					}
				}
				}else{
				failReason="Wrong Pw";
			}
		}
		log.info(failReason);
		
		Token data = new Token();

		UserInfo user = new UserInfo(m);
		data.setUser(user);
		data.setToken(passwordEncoder.encode(m.getEmail()+m.getPw()));
		data.set_admin(isAdmin);
		data.set_vip(isVip);
		
		return new ResponseEntity<Token>(data,HttpStatus.OK);
		
	}
	
	


	@PostMapping(value="/signUp",
				consumes="application/json",
				produces={MediaType.TEXT_PLAIN_VALUE})
			public ResponseEntity<String> insertMember(@RequestBody MemberVO member){
			
			int insertCount = memberService.insertMember(member);
			
			return insertCount==1
					? new ResponseEntity<>("success",HttpStatus.OK)
					: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}

}

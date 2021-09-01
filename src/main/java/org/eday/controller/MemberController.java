package org.eday.controller;
import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

import org.eday.domain.MemberVO;
import org.eday.service.CustomUserDetailService;
import org.eday.service.MemberService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
	
	@PostMapping(value="/logIn",
			consumes="application/json",
			produces={MediaType.TEXT_PLAIN_VALUE})
		public ResponseEntity<Map<MemberVO,String>> logIn(@RequestBody MemberVO member){
		String username = member.getEmail();
		String pw = member.getPw();
		String failReason="";
		
		System.out.println("이메일"+username);
		System.out.println("비번"+pw);
		
		String dbPw = service.loadUserByUsername(username).getPassword();
		if(dbPw==null){
			failReason="ID not found";
		}else{
			System.out.println(dbPw);
			if(encoder.matches(pw, dbPw)){
				failReason="Sucess";
				}else{
				failReason="Wrong Pw";
			}
		}
		Map<MemberVO,String> map = new HashMap<MemberVO, String>();
		map.put(memberService.read(username),failReason);
		return new ResponseEntity<Map<MemberVO,String>>(map,HttpStatus.OK);
		
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

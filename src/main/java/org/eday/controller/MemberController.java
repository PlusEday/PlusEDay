package org.eday.controller;
import java.security.Principal;

import org.eday.domain.MemberVO;
import org.eday.service.MemberService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
	
	private MemberService memberservice;
	

		@PostMapping(value="/signUp",
				consumes="application/json",
				produces={MediaType.TEXT_PLAIN_VALUE})
			public ResponseEntity<String> insertMember(@RequestBody MemberVO member){
			
			int insertCount = memberservice.insertMember(member);
			
			return insertCount==1
					? new ResponseEntity<>("success",HttpStatus.OK)
					: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}

}

package org.eday.controller;

import java.util.List;

import org.eday.domain.FollowVO;
import org.eday.domain.MemberVO;
import org.eday.domain.UserInfo;
import org.eday.service.CustomUserDetailService;
import org.eday.service.FollowService;
import org.eday.service.MemberService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@RequestMapping("/follow")
@RestController
@Log4j
@AllArgsConstructor
public class FollowController {

	private FollowService service;

	@ApiOperation(value="팔로우", notes="사용자가 상대를 팔로우한 이력의 여부와 상관 없이 같게 작동합니다.")
	@PostMapping(value = "/follow", consumes = "application/json", produces = { MediaType.TEXT_PLAIN_VALUE })
	public ResponseEntity<String> follow(@RequestBody FollowVO follow) {

		int re = service.follow(follow);

		return "".equals(re) ? new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR)
				: new ResponseEntity<>("success", HttpStatus.OK);
	}
	
	@ApiOperation(value="팔로잉리스트", notes="사용자가 팔로우하고 있는 회원의 리스트(목록에 출력할 정보)를 출력합니다.")
	@GetMapping(value = "/followings",
			produces={
					MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_UTF8_VALUE})
	public ResponseEntity<List<UserInfo>> getFollowings(@RequestBody String member_id){
		
		return new ResponseEntity<List<UserInfo>>(service.getFollowings(member_id),HttpStatus.OK);
	}
	
	@ApiOperation(value="팔로워리스트", notes="사용자를 팔로우하고 있는 회원의 리스트(목록에 출력할 정보)를 출력합니다.")
	@GetMapping(value = "/followers",
			produces={
					MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_UTF8_VALUE})
	public ResponseEntity<List<UserInfo>> getFollowers(@RequestBody String member_id){
		
		return new ResponseEntity<List<UserInfo>>(service.getFollowers(member_id),HttpStatus.OK);
	}

}

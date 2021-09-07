package org.eday.controller;

import java.util.List;

import org.eday.domain.HashtagVO;
import org.eday.domain.PostVO;
import org.eday.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@RestController
@Log4j
@RequestMapping("/post/")
@AllArgsConstructor
public class PostController {

	private PostService service;
	
	@PostMapping(value="/createPost", consumes="application/json", produces={MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> insertPost(@RequestBody PostVO post){
		
		log.info("Post: " + post);
		int insertCount = service.insertPost(post);
		log.info("Post Insert Count: "+ insertCount);
		
		return insertCount == 1 ? new ResponseEntity<>("success", HttpStatus.OK) : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@PostMapping(value="/searchHashtag",
			consumes = "application/json",
					produces = { MediaType.APPLICATION_JSON_UTF8_VALUE,
							MediaType.APPLICATION_JSON_UTF8_VALUE})
	public ResponseEntity<List<HashtagVO>> searchHashtag(@RequestBody String keyword) {
		
		return new ResponseEntity<List<HashtagVO>>(service.searchHashtag(keyword), HttpStatus.OK);
	}
}

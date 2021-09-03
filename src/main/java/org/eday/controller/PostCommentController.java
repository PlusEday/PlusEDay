package org.eday.controller;

import java.util.Map;

import org.eday.domain.CommentsVO;
import org.eday.service.PostCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@RequestMapping("/comment")
@RestController
@AllArgsConstructor
public class PostCommentController {
	
	@Setter(onMethod_ = @Autowired)
	private PostCommentService service;
	
	@ApiOperation(value="댓글등록", notes="사용자의 아이디, 포스트 아이디, 댓글 내용을 받습니다.")
	@PostMapping( value="/register", consumes="application/json", produces={MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> register(@RequestBody CommentsVO comment) {
		log.info("Register Comment Controller. . . . . .");
		int register_result = service.writeComment(comment);
		return register_result == 1? new ResponseEntity<String>("success", HttpStatus.OK)
				: new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ApiOperation(value="댓글수정", notes="댓글 아이디, 사용자의 아이디, 포스트 아이디, 댓글내용을 받습니다. ")
	@PostMapping( value="/modify", consumes="application/json", produces={MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> modify(@RequestBody CommentsVO comment) {
		log.info("Modify Comment Controller. . . . . .");
		int modify_result = service.modifyComment(comment);
		return modify_result == 1? new ResponseEntity<String>("success", HttpStatus.OK)
				: new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ApiOperation(value="댓글한개가져오기", notes="댓글 아이디를 받습니다. ")
	@PostMapping( value="/getOne", consumes="application/json", produces="application/json")
	public ResponseEntity<CommentsVO> getOne(@RequestBody Map<String, String> param) {
		log.info("Get One Comment Controller. . . . . . ");
		String comment_id = param.get("comment_id");
		CommentsVO vo = service.getComment(comment_id);
		return vo != null? new ResponseEntity<CommentsVO>(service.getComment(comment_id), HttpStatus.OK) :
			new ResponseEntity<CommentsVO>(HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
	@ApiOperation(value="댓글한개가져오기", notes="댓글 아이디를 받습니다. ")
	@PostMapping( value="/delete", consumes="application/json", produces={MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> delete(@RequestBody CommentsVO comment) {
		log.info("Delete Comment, Controller. . . . . .");
		int delete_result = service.removeComment(comment);
		return delete_result == 1? new ResponseEntity<String>("success", HttpStatus.OK) :
			new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
}

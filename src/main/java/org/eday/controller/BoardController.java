package org.eday.controller;

import org.eday.domain.BoardVO;
import org.eday.service.BoardService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@RestController
@RequestMapping("/board")
@Log4j
@AllArgsConstructor
public class BoardController {
	
	private BoardService service;
	
	@GetMapping(value = "/{bno}", 
			produces = {
					MediaType.APPLICATION_JSON_UTF8_VALUE,
					MediaType.APPLICATION_XML_VALUE
			}) 
	public ResponseEntity<BoardVO> get(@PathVariable("bno") Long bno){
		log.info("get. . . .");
		return new ResponseEntity<BoardVO>(service.get(bno), HttpStatus.OK);
	}
}

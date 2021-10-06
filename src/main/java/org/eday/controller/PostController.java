package org.eday.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.eday.domain.HashtagVO;
import org.eday.domain.PostVO;
import org.eday.domain.Post_photoVO;
import org.eday.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@RestController
@Log4j
@RequestMapping("/post/")
@AllArgsConstructor
public class PostController {

	private PostService service;
	
	private String getFolder() {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		Date date = new Date();

		String str = sdf.format(date);

		return str.replace("-", File.separator);
	}
	
	
	//@PostMapping(value="/createPost", consumes="application/json", produces={MediaType.TEXT_PLAIN_VALUE})
	@PostMapping(value="/createPost")
	public String insertPost
	(@RequestParam(value="detail") String detail,
	@RequestParam(value="member_id") String member_id,
	@RequestParam("file") MultipartFile[] files)throws IOException{
	
		PostVO post = new PostVO();
		post.setDetail(detail);
		post.setMember_id(member_id);
		//Post Upload
		log.info("Post: " + post);
		int insertCount = service.insertPost(post);
		log.info("Post Insert Count: "+ insertCount);
		
		//Post_photo Upload 
		
		List<Post_photoVO> photoList = new ArrayList<>();
		
		//make folder
		String uploadFolder = "C:\\upload";
		String uploadFolderPath = getFolder();
		File uploadPath = new File(uploadFolder, uploadFolderPath);
		log.info("upload path: " + uploadPath);

		if (uploadPath.exists() == false) {
			uploadPath.mkdirs();
		}
		
		for(MultipartFile multiFile : files){
		
		Post_photoVO photo = new Post_photoVO();
		
		String uploadFileName = multiFile.getOriginalFilename();
		
		uploadFileName = uploadFileName.substring(uploadFileName.lastIndexOf("\\")+1);
		log.info("only file name:" + uploadFileName);
		
		try {
			File saveFile = new File(uploadPath, uploadFileName);
			multiFile.transferTo(saveFile);
			
			photo.setPost_id("1");   // 테스트용
			photo.setPhoto_name(uploadFileName);
			photo.setUpload_path(uploadPath.toString());
			log.info(photo.getPost_id() + "//" + photo.getPhoto_name() +"//" + photo.getUpload_path());
			photoList.add(photo);
			
		} catch (Exception e) {
			// TODO: handle exception
			log.error(e.getMessage());
		}

		}
		
		for(Post_photoVO photo : photoList){
			
			log.info("++++++++++++++++++++++++++++++++++++++++");
			log.info(photo.getPost_id() + "//" + photo.getPhoto_name() +"//" + photo.getUpload_path());
			service.insertPhoto(photo);
		}
		
		return post.getPost_id();
	}
	
	@PostMapping(value="/searchHashtag",
			consumes = "application/json",
					produces = { MediaType.APPLICATION_JSON_UTF8_VALUE,
							MediaType.APPLICATION_JSON_UTF8_VALUE})
	public ResponseEntity<List<HashtagVO>> searchHashtag(@RequestBody String keyword) {
		
		return new ResponseEntity<List<HashtagVO>>(service.searchHashtag(keyword), HttpStatus.OK);
	}
}

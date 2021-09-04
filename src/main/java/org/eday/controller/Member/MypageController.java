package org.eday.controller.Member;

import java.io.IOException;

import org.eday.domain.MemberPhotoVO;
import org.eday.service.CustomUserDetailService;
import org.eday.service.MemberPhotoService;
import org.eday.service.MemberService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@RequestMapping("/mypage/")
@RestController
@Log4j
@AllArgsConstructor
public class MypageController {
	
	private MemberPhotoService profileService;
	private MemberService memberSerivce;
	
	@PostMapping("/upload")
    public String handleFileUpload(@RequestParam("file") MultipartFile file) throws IOException {
 
        MemberPhotoVO imageVO = new MemberPhotoVO();
        imageVO.setMimetype(file.getContentType());
        imageVO.setOriginal_name(file.getOriginalFilename());
        imageVO.setData(file.getBytes());
        imageVO.setMember_id("1");
        profileService.uploadProfile(imageVO);
 
        return imageVO.getMember_photo_id();
    }
	

}

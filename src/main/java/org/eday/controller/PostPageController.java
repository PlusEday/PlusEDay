package org.eday.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;

import java.io.File;
import java.io.FileOutputStream;
import java.net.URLDecoder;
import java.nio.file.Files;
import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.swing.plaf.multi.MultiTabbedPaneUI;

import org.eday.domain.AttachFileDTO;
import org.springframework.http.HttpStatus;
//import org.forwork.domain.Portfolio;
//import org.forwork.domain.PortfolioLanguage;
//import org.forwork.service.BoardService;
//import org.forwork.service.PortfolioService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
//import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.log4j.Log4j;
import net.coobird.thumbnailator.Thumbnailator;

//import lombok.AllArgsConstructor;
//import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping(value = "/post/*", produces = MediaType.TEXT_HTML_VALUE)
@Log4j
public class PostPageController {

	private String getFolder() {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		Date date = new Date();

		String str = sdf.format(date);

		return str.replace("-", File.separator);
	}

	private boolean checkImageType(File file){
		
		try {
			String contentType = Files.probeContentType(file.toPath());
			
			return contentType.startsWith("image");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	@GetMapping("/uploadPostPhoto")
	public void postPhoto() {
		log.info("upload form");
	}

	@PostMapping(value="/uploadFormAction", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseEntity<List<AttachFileDTO>> uploadFormPost(MultipartFile[] uploadFile) {

		List<AttachFileDTO> list = new ArrayList<>();
		String uploadFolder = "C:\\upload";

		String uploadFolderPath = getFolder();
		// make folder 
		File uploadPath = new File(uploadFolder, uploadFolderPath);
		log.info("upload path: " + uploadPath);

		if (uploadPath.exists() == false) {
			uploadPath.mkdirs();
		}

		for (MultipartFile multipartFile : uploadFile) {

			AttachFileDTO attachDTO = new AttachFileDTO();

			String uploadFileName = multipartFile.getOriginalFilename();

			// IE has file path
			uploadFileName = uploadFileName.substring(uploadFileName.lastIndexOf("\\") + 1);
			log.info("only file name:" + uploadFileName);
			attachDTO.setFileName(uploadFileName);

			// To avoid duplicate File Name
			UUID uuid = UUID.randomUUID();

			uploadFileName = uuid.toString() + "_" + uploadFileName;

			// File saveFile = new File(uploadFolder,
			// multipartFile.getOriginalFilename());
			

			String uploadPathWithFileName = (uploadPath + "\\" + uploadFileName);

			log.info("UploadPath with File Name :" + uploadPathWithFileName);

			try {
				File saveFile = new File(uploadPath, uploadFileName);
				multipartFile.transferTo(saveFile);
				
				attachDTO.setUuid(uuid.toString());
				attachDTO.setUploadPath(uploadPath.toString());
				attachDTO.setUploadPathWithFileName(uploadPathWithFileName);
				
				//check image type file
				if (checkImageType(saveFile)){
					
					attachDTO.setImage(true);
					
					//create thumbnail image file - start File Name with "s_"
					FileOutputStream thumbnail = new FileOutputStream(new File(uploadPath, "s_"+uploadFileName));
					Thumbnailator.createThumbnail(multipartFile.getInputStream(), thumbnail, 100, 100);
					thumbnail.close();
					
					String thumbnailName = ("s_"+uploadFileName);
					attachDTO.setThumbnailName(thumbnailName);
					log.info("Thumnail Name:" + thumbnailName);
					
					String thumbnailPath = (uploadPath + "\\s_"+uploadFileName);
					attachDTO.setThumbnailPath(thumbnailPath);
					log.info("Thumbnail Path: " + thumbnailPath);
				}
				//add to List
				list.add(attachDTO);
				for(AttachFileDTO a:list){
					log.info("------- Check Upload File Info -------");
					log.info(a.getFileName());
					log.info(a.getUploadPath());
					log.info(a.getUploadPathWithFileName());
					log.info(a.getUuid());
				}
				
			} catch (Exception e) {
				log.error(e.getMessage());
			} // end catch
		} // end for
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	
	@PostMapping("/deleteFile")
	@ResponseBody
	public ResponseEntity<String> deleteFile(String fileName, String type){
		log.info("deleteFile:" + fileName);
		
		File file;
		try {
			file = new File("C:\\upload\\"+URLDecoder.decode(fileName,"UTF-8"));
			file.delete();
			if(type.equals("image")){
				String largeFileName = file.getAbsolutePath().replace("s_", "");
				log.info("largeFileName:" + largeFileName);
				file = new File(largeFileName);
				file.delete();
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<String>("deleted",HttpStatus.OK);
	}

}
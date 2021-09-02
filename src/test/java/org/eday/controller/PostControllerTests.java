package org.eday.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import org.eday.domain.PostVO;
import org.eday.domain.Post_likeVO;
import org.eday.mapper.PostMapperTests;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.google.gson.Gson;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes={ org.eday.config.RootConfig.class, org.eday.config.SecurityConfig.class})
@Log4j
@WebAppConfiguration
public class PostControllerTests {
	
	@Setter(onMethod_=@Autowired)
	private WebApplicationContext ctx;
	
	private MockMvc mockMvc;
	
	@Before
	public void setUp(){
		this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
	}

	/*@Test
	public void testConvert() throws Exception {
		
		PostVO post = new PostVO();
		post.setDetail("오늘은 제로웨이스트를 실천했다.");
		post.setMember_id("3");
		
		String jsonStr = new Gson().toJson(post);
		
		log.info(jsonStr);
		
		mockMvc.perform(MockMvcRequestBuilders.post("/post/createPost/")
				.contentType(MediaType.APPLICATION_JSON)
				.content(jsonStr));
	}*/
	
	@Test
	public void testinsertPostLike() throws Exception {
		Post_likeVO likevo = new Post_likeVO();
		likevo.setMember_id("2");
		likevo.setPost_id("2");
		likevo.setLike_toggle("y");
		
		String jsonStr = new Gson().toJson(likevo);
		log.info(likevo);
		
		mockMvc.perform(MockMvcRequestBuilders.post("/post/likePost")
				.contentType(MediaType.APPLICATION_JSON)
				.content(jsonStr)
				);
	}
}

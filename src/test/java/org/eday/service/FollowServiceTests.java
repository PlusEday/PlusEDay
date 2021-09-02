package org.eday.service;

import org.eday.domain.FollowVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@Log4j
@ContextConfiguration(classes={ org.eday.config.RootConfig.class, org.eday.config.SecurityConfig.class})
@WebAppConfiguration
public class FollowServiceTests {

	@Setter(onMethod_={@Autowired})
	private FollowService service;
	
	
	@Test
	public void test(){
		log.info(service.getFollowings("1"));
	}
	

	@Test
	public void follow(){
		FollowVO follow=new FollowVO();
		
		follow.setFollowing_id("1");
		follow.setMember_id("13");
		log.info(service.follow(follow));
	}
}

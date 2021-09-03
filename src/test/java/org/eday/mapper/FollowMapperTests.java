package org.eday.mapper;

import java.util.List;

import org.eday.domain.FollowVO;
import org.eday.domain.MemberVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes={ org.eday.config.RootConfig.class, org.eday.config.SecurityConfig.class})
@Log4j
public class FollowMapperTests {

	
	@Setter(onMethod_= @Autowired)
	private FollowMapper mapper;
	
//	@Test
//	public void testInitF(){
//		FollowVO follow = new FollowVO();
//		
//		follow.setMember_id("1");
//		follow.setFollowing_id("2");
//		mapper.initFollow(follow);
//		
//	}
	
	@Test
	public void getFolloings(){
		String member_id= "1";
		List<MemberVO> f = mapper.getFollowings(member_id);
		log.info(f.get(0));				
	}
	
//	@Test
//	public void testCheck(){
//		FollowVO follow = new FollowVO();
//		
//		follow.setMember_id("1");
//		follow.setFollowing_id("2");
//		
//		
//		String t = mapper.checkFollow(follow);
//				log.info(t);
//	}

}

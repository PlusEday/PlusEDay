package org.eday.persistence;

import static org.junit.Assert.fail;

import java.sql.Connection;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.eday.config.RootConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RootConfig.class})
public class DataSourceTests {
	@Setter(onMethod_ = {@Autowired})
	private DataSource dataSource;
	
	@Setter(onMethod_ = {@Autowired})
	private SqlSessionFactory sqlSessionFactory;
	
	// DataSource를 이용한 Connection 테스트
	@Test
	public void testConnection(){
		try(Connection con = dataSource.getConnection()){
			log.info(con);
		} catch(Exception e){
			fail(e.getMessage());
		}
	}
	
	// 세션 생성 후 커넥션까지 테스트
	@Test
	public void testMyBatis() {
		try(SqlSession session = sqlSessionFactory.openSession();
				Connection con = session.getConnection();
				) {
			log.info(session);
			log.info(con);
		} catch(Exception e) {
			fail(e.getMessage());
		}
	}
}

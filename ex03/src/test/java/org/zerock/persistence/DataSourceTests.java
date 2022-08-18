package org.zerock.persistence;

import java.sql.Connection;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.config.RootConfig;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RootConfig.class})
@Log4j
public class DataSourceTests {

	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private SqlSessionFactory sqlSessionFactory;

	// hikari datasource 검사하기
	@Test
	public void testConnection() {

		try (Connection conn = dataSource.getConnection()) {
			log.info(conn);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// hikariCP의 DataSource를 이용한 mybatis connection 검사하기
	@Test
	public void testMyBatis() {
		
		try (SqlSession session = sqlSessionFactory.openSession()){
			Connection conn = session.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

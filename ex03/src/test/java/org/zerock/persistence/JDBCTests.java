package org.zerock.persistence;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

import lombok.extern.log4j.Log4j;

@Log4j
public class JDBCTests {

	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testConnection() {
		
		try {
			String url = "jdbc:oracle:thin:@localhost:1521:XE";
			String user = "book_ex";
			String password = "book_ex";
			Connection conn = DriverManager.getConnection(url, user, password);
			log.info(conn);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

package org.simple.dbTest;

import java.sql.Connection;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class DbTest {
//	
//	BbsService service;
//	
//	@Autowired
//	public void setBbsService(BbsService service) {
//		this.service = service;
//	}
//	
//	@Test
//	public void testCreate() {
//		BbsVO vo = new BbsVO();
//		
//		vo.setId("testId1");
//		vo.setName("testName1");
//		vo.setAdress("testAddress1");
//		
//		service.register(vo);
//	}

	@Autowired
	private DataSource ds;
	
	@Test
	public void testConnection() {
		try(Connection conn = ds.getConnection()){
			System.out.println(conn);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}

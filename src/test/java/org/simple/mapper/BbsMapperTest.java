package org.simple.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.simple.domain.BbsVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class BbsMapperTest {
	
	BbsMapper mapper;
	
	Logger log = LoggerFactory.getLogger(BbsMapperTest.class);
			
	@Autowired
	public void setMapper(BbsMapper mapper) {
		this.mapper = mapper;
	}
	
	@Test
	public void testCreate() {
		BbsVO vo = new BbsVO();
		
		vo.setId("TestId1");
		vo.setName("TestName1");
		
		vo.setAdress("TestAddress1");
		
		mapper.create(vo);
	}
//	
//	@Test
//	public void testRead() {
//		mapper.read(1);
//	}
//	
//	@Test
//	public void testUpdate() {
//		
//		BbsVO vo = mapper.read(2);
//		
//		vo.setAdress("updateAddress");
//		
//		mapper.update(vo);
//		
//	}
//	
//	@Test
//	public void testDelete() {
//		mapper.delete(1);
//	}

//	@Test
//	public void testList() {
//		List<BbsVO> list = mapper.list();
//		
//		list.forEach(obj -> System.out.println(obj));
//	}
}

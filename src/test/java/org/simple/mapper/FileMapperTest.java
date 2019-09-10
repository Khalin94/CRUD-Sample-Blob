package org.simple.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class FileMapperTest {
	
	Logger log = LoggerFactory.getLogger(FileMapperTest.class);
	
	FileMapper mapper;
	
	@Autowired
	private void setFileMapper(FileMapper mapper) {
		this.mapper = mapper;
	}
	
//	@Test
//	public void testInsert() {
//		FileVO vo = new FileVO();
//		
//		String uuid = UUID.randomUUID().toString().replaceAll("-", "");
//		
//		vo.setBno(28);
//		vo.setFilename("testFile");
//		vo.setUuid(uuid);
//		
//		mapper.insert(vo);
//	}
	
	@Test
	public void testFindByBno() {
		
     mapper.findByBno(28);
		
		
	}

}

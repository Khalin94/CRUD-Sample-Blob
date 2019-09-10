package org.simple.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.simple.domain.EduVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class ServiceTest {
	
	BbsService service;
	
	@Autowired
	public void setBbsService(BbsService service) {
		this.service = service;
	}
	
	FileService fileService;
	
	@Autowired
	public void setFileService(FileService fileService) {
		this.fileService = fileService;
	}
	
	EduService eduService;
	
	@Autowired
	public void setEduService(EduService eduService) {
		this.eduService = eduService;
	}
	/*
	@Test
	public void testGet() {
		service.get(1239);
	}
	*/
	/*
	@Test
	public void testRegister() {
		BbsVO vo = new BbsVO();
		
		FileVO fileVo = new FileVO();
		fileVo.setBno(1203);
		fileVo.setFilename("test");
		fileVo.setPath("testPath");
		fileVo.setUuid("testUuid");
		
		vo.setFileVo(fileVo);
		try {
			service.register(vo);
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("잘못된 값 입력!");
		}
	}
	*/
	@Test
	public void testEduGet() {
		EduVO eduVo = (EduVO) eduService.findByBno(1239);
		
		System.out.println(eduVo.getBno());
		System.out.println(eduVo.getDivision());
		System.out.println(eduVo.getEndDate());
		System.out.println(eduVo.getsName());
		
		
	}

	/*
	@Test
	public void testFileGet() {
		FileVO fileVo = fileService.findByBno(1190);
		
		System.out.println(fileVo.getFilename());
		System.out.println(fileVo.getFno());
		System.out.println(fileVo.getPath());
		System.out.println(fileVo.getUuid());
		
	}
	*/
//	@Test
//	public void testModify() {
//		BbsVO vo = service.get(25);
//		
//		vo.setId("updateId");
//		
//		service.modify(vo);
//	}
	
//	@Test
//	public void testDelete() {
//		service.remove(1);
//	}
	
//	@Test
//	public void testGetAll() {
//		List<BbsVO> list = service.getAll();
//		
//		Iterator iter = list.iterator();
//		
//		while(iter.hasNext()) {
//			System.out.println(iter.next());
//		}
//	}
}

package org.simple.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.simple.domain.TestVo;
import org.simple.mapper.TestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class TestService {
	
	TestMapper mapper;
	
	@Autowired
	public void setTestMapper(TestMapper mapper) {
		this.mapper = mapper;
	}
	
	public void register(MultipartFile file) throws IOException {

		TestVo vo =  new TestVo();
		File checkType = new File(file.getOriginalFilename());
		
		String filename = file.getOriginalFilename();
		String ext = filename.substring(filename.lastIndexOf(".")+1);
		
		vo.setFilename(filename);
		vo.setExt(ext);
		vo.setFileType(checkFileType(checkType));
		vo.setImage(file.getBytes());
		
		mapper.insert(vo);
	}
	
	/* mimeType 확인을 위한 메소드 */
	private String checkFileType(File file) {
		Path path = Paths.get(file.getAbsolutePath());

		try {
			return Files.probeContentType(path);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("checkFileType Method Error!");
		}
		return null;
	}
	
	public TestVo get(int tno) {
		return mapper.select(tno);
	}
	
	public List<TestVo> list(){
		return mapper.selectAll();
	}

}

package org.simple.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

import org.simple.domain.FileVO;
import org.simple.mapper.FileMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileUploadService {
	
	FileMapper mapper;
	
	@Autowired
	private void setFileMapper(FileMapper mapper) {
		this.mapper = mapper;
	}
	
//	public void reigster(FileVO vo) {
//		mapper.insert(vo);
//	}
//	
	
	public String restore(MultipartFile multipartFile, FileVO vo) {
		String url = null;
		
		String originalFileName = multipartFile.getOriginalFilename();
		String ext = originalFileName.substring(originalFileName.lastIndexOf("."), originalFileName.length());
		
//		int randNum =  (int)Math.random() * 1000 + 1;
		
		String uuid = UUID.randomUUID().toString().replaceAll("-", "");
		String saveFilename = uuid + ext;
//		
//		vo.setFilename(originalFileName);
//		vo.setPath("G:\\upload\\");
//		vo.setUuid(uuid);
////		
		mapper.insert(vo);
		try {
			writeFile(multipartFile, saveFilename);
			url = "G:"+File.separator+"upload"+File.separator + saveFilename;
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		System.out.println(url);
		return url;
		
	}
	
	public boolean writeFile(MultipartFile file, String saveFile) throws IOException{
		boolean result =  false;
		byte[] data = file.getBytes();
		
		
		FileOutputStream fos = new FileOutputStream("G:\\upload\\"+saveFile);
		fos.write(data);
		
		fos.close();
		
		return result;
		
	}
}

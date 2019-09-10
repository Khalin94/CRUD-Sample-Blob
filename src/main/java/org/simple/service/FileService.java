package org.simple.service;

import java.util.UUID;

import org.simple.domain.FileVO;
import org.simple.mapper.FileMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FileService {
	
	FileMapper mapper;
	
	@Autowired
	public void setFileMapper(FileMapper mapper) {
		this.mapper = mapper;
	}
	
	public void insert(FileVO vo) {
		String uuid = UUID.randomUUID().toString();

		vo.setUuid(uuid);
		mapper.insert(vo);
	}
	
	public FileVO findByBno(int bno) {
		return mapper.findByBno(bno);
	}
	
	public void removeFile(int bno) {
		mapper.removeFile(bno);
	}

}

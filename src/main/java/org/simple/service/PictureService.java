package org.simple.service;

import org.simple.domain.PictureVO;
import org.simple.mapper.PictureMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PictureService {
	
	PictureMapper mapper;
	
	@Autowired
	private void setPictureMapper(PictureMapper mapper) {
		this.mapper = mapper;
	}
	
	public void insert(PictureVO vo) {
		mapper.insertPicture(vo);
	}

}

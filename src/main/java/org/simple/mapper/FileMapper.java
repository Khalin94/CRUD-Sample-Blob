package org.simple.mapper;

import org.apache.ibatis.annotations.Delete;
import org.simple.domain.FileVO;

public interface FileMapper {
	
	public void insert(FileVO vo);
	
	public FileVO findByBno(int  bno);
	
	@Delete("delete tbl_file where bno = #{bno}")
	public void removeFile(int bno);
	

}

package org.simple.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.simple.domain.EduVO;

public interface EduMapper {
	
	public void insert(EduVO vo);
	
	public List<EduVO> findByBno(int bno);
	
	@Delete("delete tbl_edu where bno = #{bno}")
	public void removeEdu(int bno);
	
	@Delete("delete tbl_edu where eno = #{eno}")
	public void removeEduByEno(int eno);

}

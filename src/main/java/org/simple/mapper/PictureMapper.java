package org.simple.mapper;

import org.apache.ibatis.annotations.Insert;
import org.simple.domain.PictureVO;

public interface PictureMapper {

	@Insert("insert tbl_picture (picture, bno) values (#{picture}, #{bno}")
	public void insertPicture(PictureVO vo);
}

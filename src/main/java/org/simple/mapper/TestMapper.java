package org.simple.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.simple.domain.TestVo;

public interface TestMapper {
	
	@Insert("insert into tbl_test (tno, image, fileType, ext, filename) values(seq_test.nextval, #{image}, #{fileType}, #{ext}, #{filename})")
	public void insert(TestVo vo);
	
	@Select("select * from tbl_test where tno = #{tno}")
	public TestVo select(int tno);
	
	@Select("select * from tbl_test")
	public List<TestVo> selectAll();

}

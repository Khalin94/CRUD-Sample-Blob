package org.simple.service;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.type.TypeException;
import org.mybatis.spring.MyBatisSystemException;
import org.simple.domain.BbsVO;

public interface BbsService {
	
	public void register(BbsVO vo) throws MyBatisSystemException, TypeException, SQLException;
	
	public BbsVO get(int bno);
	
	public void modify(BbsVO vo);
	
	public void remove(int bno);
	
	public List<BbsVO> getAll();
	
	public void removeList(int bno);

	public int bnoVal();
}

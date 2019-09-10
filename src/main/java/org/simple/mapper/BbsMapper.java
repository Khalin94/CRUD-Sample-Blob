package org.simple.mapper;

import java.util.List;

import org.simple.domain.BbsVO;

public interface BbsMapper {

	public void create(BbsVO vo);
	
	public BbsVO read(int bno);
	
	public void update(BbsVO vo);
	
	public void delete(int bno);
	
	public List<BbsVO> list();
	
	public void deleteList(BbsVO vo);
	
	public int makeBno();
	
	public int bnoVal();
}

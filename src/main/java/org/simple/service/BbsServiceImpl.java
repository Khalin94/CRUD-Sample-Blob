package org.simple.service;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.type.TypeException;
import org.mybatis.spring.MyBatisSystemException;
import org.simple.domain.BbsVO;
import org.simple.mapper.BbsMapper;
import org.simple.mapper.EduMapper;
import org.simple.mapper.FileMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BbsServiceImpl implements BbsService {

	Logger log = LoggerFactory.getLogger(BbsServiceImpl.class);

	BbsMapper mapper;
	FileMapper fileMapper;
	EduMapper eduMapper;
	
	@Autowired
	public void setMapper(BbsMapper mapper) {
		this.mapper = mapper;
	}


	@Autowired
	public void setFileMapper(FileMapper fileMapper) {
		this.fileMapper = fileMapper;
	}


	@Autowired
	public void setEduMapper(EduMapper eduMapper) {
		this.eduMapper = eduMapper;
	}

	@Transactional
	@Override
	public void register(BbsVO vo) throws MyBatisSystemException, TypeException, SQLException {

		try {
			mapper.create(vo);
/*
			FileVO fileVo = fileMapper.findByBno(vo.getBno());

			String uuid = UUID.randomUUID().toString();

			fileVo.setUuid(uuid);
	*/		
			if (vo.getFileVo() == null) {
				System.out.println("fileVo is Null");
				return;
			}
/*			
			System.out.println(vo.getFileVo());

			if (fileVo.getFilename() != null) {
				fileMapper.insert(fileVo);
			}
			
			ArrayList<EduVO> eduList = vo.getEduVo();

			for (EduVO eduVo : eduList) {

				System.out.println("eduVo startDate : " + eduVo.getStartDate());

				String startDate = eduVo.getStartYear() + "-" + eduVo.getStartMonth() + "-" + eduVo.getStartDay();

				System.out.println(startDate);

				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

				Date tranStartDate = sdf.parse(startDate);

				System.out.println("tranStartDate : " + tranStartDate);

				eduVo.setStartDate(tranStartDate);

				String endDate = eduVo.getEndYear() + "-" + eduVo.getEndMonth() + "-" + eduVo.getEndDay();

				Date tranEndDate = sdf.parse(endDate);

				System.out.println("tranEndDate : " + tranEndDate);

				eduVo.setEndDate(tranEndDate);

				eduMapper.insert(eduVo);
			}
*/
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public BbsVO get(int bno) {
		BbsVO vo = mapper.read(bno);
		/*
		 * if (vo.getIdNum() == null) { vo.setIdNum("0000000000000"); } else { Character
		 * ch = vo.getIdNum().charAt(6); String str = ch.toString();
		 * 
		 * int genderCode = Integer.valueOf(str); if (genderCode == 1) {
		 * vo.setGender(1); } else if (genderCode == 2) { vo.setGender(2); } else {
		 * vo.setGender(0); System.out.println("잘못된 값"); } }
		 */
		vo = makeGenderCode(vo);
		
		System.out.println(vo.getGender());
		return vo;
	}

	private BbsVO makeGenderCode(BbsVO vo) {
		if (vo.getIdNum() == null) {
			vo.setIdNum("0000000000000");
		}
		Character ch = vo.getIdNum().charAt(6);
		String str = ch.toString();

		int genderCode = Integer.valueOf(str);

		if (genderCode == 1) {
			vo.setGender(1);
		} else if (genderCode == 2) {
			vo.setGender(2);
		} else {
			System.out.println("잘못된 값");
			vo.setGender(-1);
		}

		return vo;
	}

	@Override
	public void modify(BbsVO vo) {
		mapper.update(vo);
	}

	@Override
	public void remove(int bno) {
		
		mapper.delete(bno);
	}

	@Override
	public List<BbsVO> getAll() {
		return mapper.list();
	}

	@Override
	public void removeList(int bno) {

//		Iterator<BbsVO> iter = vo.iterator();
		/*
		 * while(iter.hasNext()) { BbsVO bbsVo = iter.next();
		 * System.out.println("removeList Bno : " + bbsVo.getBno());
		 * mapper.delete(bbsVo.getBno()); }
		 */
		/*
		 * vo.forEach(bbs -> { mapper.delete(bbs.getBno()); });
		 */

		mapper.delete(bno);
	}


	@Override
	public int bnoVal() {
		// TODO Auto-generated method stub
		return mapper.bnoVal();
	}
	

}

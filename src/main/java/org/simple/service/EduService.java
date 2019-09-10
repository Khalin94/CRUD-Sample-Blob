package org.simple.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.simple.domain.EduVO;
import org.simple.mapper.EduMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EduService {

	EduMapper eduMapper;

	@Autowired
	public void setEduMapper(EduMapper eduMapper) {
		this.eduMapper = eduMapper;
	}

	public void register(EduVO vo) throws Exception {
		// List<EduVO> eduList = vo.getEduVo();

		String[] sName = vo.getsName().split(",");
		String[] major = vo.getMajor().split(",");
		String[] startYear = vo.getStartYear().split(",");
		String[] startMonth = vo.getStartMonth().split(",");
		String[] startDay = vo.getStartDay().split(",");
		String[] endYear = vo.getEndYear().split(",");
		String[] endMonth = vo.getEndMonth().split(",");
		String[] endDay = vo.getEndDay().split(",");
		String[] division = vo.getDivision().split(",");

		for (int i = 0; i < sName.length; i++) {
			vo.setsName(sName[i]);
			vo.setMajor(major[i]);
			vo.setStartYear(startYear[i]);
			vo.setStartMonth(startMonth[i]);
			vo.setStartDay(startDay[i]);
			vo.setEndYear(endYear[i]);
			vo.setEndMonth(endMonth[i]);
			vo.setEndDay(endDay[i]);
			vo.setDivision(division[i]);

			String startDate = vo.getStartYear() + "-" + vo.getStartMonth() + "-" + vo.getStartDay();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date tranStartDate = sdf.parse(startDate);

			vo.setStartDate(tranStartDate);

			String endDate = vo.getEndYear() + "-" + vo.getEndMonth() + "-" + vo.getEndDay();
			Date tranEndDate = sdf.parse(endDate);

			vo.setEndDate(tranEndDate);

			eduMapper.insert(vo);
		}
	}

	public List<EduVO> findByBno(int bno) {

		return eduMapper.findByBno(bno);

	}

	public void removeEdu(int bno) {
		eduMapper.removeEdu(bno);
	}
	
	public void removeByEno(int eno) {
		eduMapper.removeEduByEno(eno);
	}
}

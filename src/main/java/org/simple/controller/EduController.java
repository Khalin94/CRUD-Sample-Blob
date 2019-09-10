/*package org.simple.controller;

import org.simple.domain.EduVO;
import org.simple.service.BbsService;
import org.simple.service.EduService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EduController {
	
	BbsService service;
	EduService eduService;
	
	@Autowired
	public void setBbsService(BbsService service) {
		this.service = service;
	}
	
	@Autowired
	public void setEduService(EduService eduService) {
		this.eduService = eduService;
	}
	
	@PostMapping("/eduInfo")
	public ResponseEntity<EduVO> regEdu(EduVO eduVo, @RequestParam int bno) {
		eduVo.setBno(bno);
		System.out.println("SName : " + eduVo.getsName());
		System.out.println("division : " + eduVo.getDivision());
		
		try {
			eduService.register(eduVo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return new ResponseEntity<EduVO>(eduVo, HttpStatus.OK);
	}

}
*/
package org.simple.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.simple.domain.TestVo;
import org.simple.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Controller
public class TestController {
	/**************** 테스트 페이지를 위한 컨트롤러 *******************/

	TestService testService;

	@Autowired
	private void setTestService(TestService testService) {
		this.testService = testService;
	}

	//게시글 등록 page 이동 method
	@GetMapping("/testpage")
	public String testpage() {

		return "/test/testpage";
	}
	//게시글 등록 method
	@PostMapping("/testpage")
	public String testpage(MultipartHttpServletRequest request, @RequestHeader HttpHeaders header) throws IOException {

		System.out.println(header.getContentType());

		System.out.println("==start controller testpage==");

		MultipartFile file = request.getFile("image");

		testService.register(file);

		return "redirect:/testList";
	}

	//게시글 조회 Method
	@GetMapping("/getTestpage")
	public String getTestPage(Model model, int tno, TestVo vo) {
		model.addAttribute("tno", tno);
		model.addAttribute("vo", testService.get(tno));
		return "/test/getTestpage";
	}

	//게시글 리스트 읽어오는 Method
	@GetMapping("/testList")
	public String testList(Model model) {

		model.addAttribute("list", testService.list());

		return "/test/testList";

	}
	
	/*
	 * Oracle에 저장된 Blob형식을 읽어오기 위해 ResponseEntity의 제네릭스를 byte[]형식으로 지정해줌
	*/
	
	//이미지를 보여주는 메소드
	@GetMapping("/viewImage")
	public ResponseEntity<byte[]> viewImage(Model model, @RequestParam int tno) {

		TestVo vo = testService.get(tno);

		HttpHeaders header = new HttpHeaders();

//		if (vo.getFileType().contains("image")) {
//			header.setContentType(MediaType.IMAGE_PNG);
//		}

//		if(vo.getExt() == "jpeg" || vo.getExt() == "png" || vo.getExt() == "jpg") {
//			header.setContentType(MediaType.IMAGE_PNG);
//		}else {
//			header.setContentType(MediaType.APPLICATION_PDF);
//		}
		System.out.println(header.getContentType());
		System.out.println(tno);

		return new ResponseEntity<byte[]>(vo.getImage(), header, HttpStatus.OK);
	}

	//다운로드 메소드
	@GetMapping("/download")
	public ResponseEntity<byte[]> download(int tno, HttpServletResponse res) throws IOException {
		TestVo vo = testService.get(tno);
		//download를 위해 ContentType을 application/octet-stream으로 지정해줌
		res.setContentType("application/octet-stream");
		HttpHeaders header = new HttpHeaders();
		//download 받는 클라이언트 컴퓨터에 저장될 파일이름 지정
		header.add("Content-Disposition", "attachment; filename=\""+vo.getFilename()+"\"");
		//download를 위해 ContentType을 application/octet-stream으로 지정해줌
		header.setContentType(MediaType.APPLICATION_OCTET_STREAM);

		return new ResponseEntity<byte[]>(vo.getImage(), header, HttpStatus.OK);
	}

	//pdf파일 새창열기 메소드
	@GetMapping("/preview")
	public ResponseEntity<byte[]> preview(int tno, HttpServletResponse res) throws IOException {
		//tno 값에 맞는 vo들을 읽어옴.
		TestVo vo = testService.get(tno);

		//pdf파일이라고 헤더에 명시해줌
		HttpHeaders header = new HttpHeaders();
		header.setContentType(MediaType.APPLICATION_PDF);
		res.setContentType("application/pdf; charset=utf-8");

		//byte[]값을 리턴해서 새창에서 띄어줄 수 있게 함.
		return new ResponseEntity<byte[]>(vo.getImage(), header, HttpStatus.OK);
	}

}

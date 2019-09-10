/*package org.simple.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.UUID;

import javax.servlet.http.HttpServletResponse;

import org.simple.domain.FileVO;
import org.simple.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Controller
public class UploadController {

	FileService service;

	@Autowired
	private void setFileService(FileService service) {
		this.service = service;
	}

	@PostMapping("/uploadFile")
	@ResponseBody
	public ResponseEntity<FileVO> uploadFile(MultipartHttpServletRequest request, FileVO fileVo) {
		Iterator<String> iter = request.getFileNames();
		// if(iter.hasNext()) {
		MultipartFile mpf = request.getFile(iter.next());
		System.out.println(mpf.getOriginalFilename() + " uploaded");
//		FileVO fileVo = new FileVO();
		String path =  "G:"+File.separator+"upload"+File.separator;
		
//		FileVO fileVo = new FileVO();

		try {
			System.out.println("file Length : " + mpf.getBytes().length);
			System.out.println("file name : " + mpf.getOriginalFilename());
			mpf.transferTo(new File(path, mpf.getOriginalFilename()));

			fileVo.setFilename(mpf.getOriginalFilename());
			fileVo.setPath(path);
	//		vo.setBno(0);
	//		fileVo.setBno(vo.getBno());
			UUID uuid = UUID.randomUUID();
			fileVo.setUuid(uuid.toString());

	//		service.insert(fileVo);

			System.out.println("filename : " + fileVo.getFilename() + " path : " + fileVo.getPath());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		// fileService.insert(vo);
//		}
		return new ResponseEntity<FileVO>(fileVo, HttpStatus.OK);
	}
	
	@PostMapping("/download")
	public String download(@RequestParam int bno, HttpServletResponse response) throws Exception {
		FileVO fileVo = service.findByBno(bno);
		
		System.out.println("download bno : " + bno);
		String path = fileVo.getPath();
		System.out.println("path : " + path);
		String filename = fileVo.getFilename();
		System.out.println("filename : " + filename);
		
		String fullName = path+filename;
		Resource resource = new FileSystemResource(fullName);
		
		System.out.println(resource.getFilename());
		
		File file = new File(fullName);
		int i = 0;
		
		FileInputStream fis = null;
		FileOutputStream fos = null;
		
		try {
			fis = new FileInputStream(file);
			fos = new FileOutputStream(filename);
			
			while((i=fis.read()) != -1){
				fos.write(i);
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {

			fis.close();
			fos.close();
		}
		
		
		HttpHeaders header = new HttpHeaders();
		
		String downloadName = null;
		
		try {
			downloadName = URLEncoder.encode(filename, "utf-8");
			System.out.println("download DownloadName : " + downloadName);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		header.add("content-disposition", "attachment); filename="+downloadName);
		
		//fileInput Output Stream 사용해야 될것 같음!
		
		return "redirect:/bbsGet?bno="+bno;
		
		
		
	}
	
	@GetMapping("/test")
	@ResponseBody
	public ResponseEntity<FileVO> test(){
		FileVO fileVo = new FileVO();
		
		fileVo.setBno(2);
		fileVo.setFilename("test");
		fileVo.setFno(2);
		fileVo.setPath("G:\\asdf");
		fileVo.setUuid("wefa3d34r4");
		
		return new ResponseEntity<FileVO>(fileVo, HttpStatus.OK);
	}
}
*/

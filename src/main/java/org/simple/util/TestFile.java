/*
package com.jun7222.www.controller;

import java.io.File;
import java.util.Iterator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Controller
public class FileUploadController {
	@RequestMapping(value = "/ajaxUpload")
	public String ajaxUpload() {
		return "ajaxUpload";
	}

	@RequestMapping(value = "/fileUpload")
	public String fileUp(MultipartHttpServletRequest multi) {
		String root = multi.getSession().getServletContext().getRealPath("/");
		String path = root + "resources/upload/";
		String newFileName = "";
		File dir = new File(path);
		if (!dir.isDirectory()) {
			dir.mkdir();
		}
		Iterator<String> files = multi.getFileNames();
		while (files.hasNext()) {
			String uploadFile = files.next();
			MultipartFile mFile = multi.getFile(uploadFile);
			String fileName = mFile.getOriginalFilename();
			System.out.println("실제 파일 이름 : " + fileName);
			newFileName = System.currentTimeMillis() + "." + fileName.substring(fileName.lastIndexOf(".") + 1);
			try {
				mFile.transferTo(new File(path + newFileName));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println("id : " + multi.getParameter("id"));
		System.out.println("pw : " + multi.getParameter("pw"));
		return "ajaxUpload";
	}
}
*/
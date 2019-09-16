package org.simple.controller;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.simple.domain.BbsVO;
import org.simple.domain.EduVO;
import org.simple.domain.FileVO;
import org.simple.domain.PictureVO;
import org.simple.service.BbsService;
import org.simple.service.EduService;
import org.simple.service.FileService;
import org.simple.service.PictureService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	final static String PATH = "G:" + File.separator + "upload" + File.separator;

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	BbsService service;
	FileService fileService;
	EduService eduService;
	PictureService pictureService;

	@Autowired
	private void setPictureService(PictureService pictureService) {
		this.pictureService = pictureService;
	}

	@Autowired
	private void setBbsService(BbsService service) {
		this.service = service;
	}

	@Autowired
	private void setFileService(FileService fileService) {
		this.fileService = fileService;
	}

	@Autowired
	private void setEduService(EduService eduService) {
		this.eduService = eduService;
	}

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

		return "home";
	}

	@GetMapping("/register")
	public String register(Model model) {
//		model.addAttribute("bno", bno);
		return "/bbs/register";
	}

	@PostMapping("/register")
	public String register(BbsVO vo, RedirectAttributes ra, MultipartHttpServletRequest file, FileVO fileVo,
			EduVO eduVo) {
		/*
		 * Iterator<String> filenames = file.getFileNames();
		 * 
		 * while(filenames.hasNext()) { MultipartFile mpf =
		 * file.getFile(filenames.next());
		 * 
		 * String filename = mpf.getOriginalFilename(); try { byte[] bytes =
		 * mpf.getBytes();
		 * 
		 * try { Blob blob = new SerialBlob(bytes);
		 * 
		 * vo.setPicture(blob); } catch (SerialException e) { // TODO Auto-generated
		 * catch block e.printStackTrace(); } catch (SQLException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); }
		 * 
		 * } catch (IOException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 * 
		 * 
		 * }
		 */
		/*
		 * Iterator<String> fileIter = file.getFileNames();
		 * 
		 * while(fileIter.hasNext()) { MultipartFile mpf =
		 * file.getFile(fileIter.next());
		 * 
		 * String fileName = mpf.getOriginalFilename(); File filePath = new
		 * File(fileName);
		 * 
		 * String strFilePath = filePath.getPath();
		 * 
		 * 
		 * vo.setPicture(Utils.imageToByte(strFilePath));
		 * 
		 * }
		 */
		System.out.println("bno : " + vo.getBno());

		ra.addFlashAttribute("bno", vo.getBno());

		try {

			service.register(vo);

		} catch (Exception e) {
			return "/error/errorPage";
		}

		// file
		
		if (file.getFile("picture").getSize() != 0) {
			try {
				// Iterator<String> iter = file.getFileNames();
//				MultipartFile mpf = file.getFile(iter.next());
				MultipartFile mpf = file.getFile("picture");
				String filename = mpf.getOriginalFilename();

				System.out.println("filename : " + filename + " Path : " + PATH);
				System.out.println("fileSize : " + file.getFile("picture").getSize());
				
				File targetfile = new File(PATH + filename);

				InputStream fileStream = mpf.getInputStream();
				FileUtils.copyInputStreamToFile(fileStream, targetfile);

				fileVo.setFilename(filename);
				fileVo.setPath(PATH);

				vo.setFileVo(fileVo);

				fileVo.setBno(vo.getBno());
				System.out.println("file Vo getfileName Length : " + fileVo.getFilename().length());

				if (fileVo.getFilename().length() != 0) {
					fileService.insert(fileVo);
				}
			} catch (Exception e) {
				System.out.println("controller file exception!");
				e.printStackTrace();
			}
		}

		// edu

		try {
			vo.setEduVo(eduVo);

			eduVo.setBno(vo.getBno());
			if (eduVo.getsName() != null) {
				eduService.register(eduVo);
			}
			// service에서 insert를 사용해야 함 . service 안에서 transaction 처리!
//			fileService.insert(fileVo);
		} catch (Exception e) {
			System.out.println("controller edu exception!");
			e.printStackTrace();
		}

		return "redirect:/bbsList";
	}

	/*
	 * private static void imageResize(MultipartFile multipartFile) throws
	 * IOException { File file = new File(multipartFile.getOriginalFilename());
	 * multipartFile.transferTo(file);
	 * 
	 * Image image = ImageIO.read(file);
	 * 
	 * Image resizeImage = image.getScaledInstance(295, 354, Image.SCALE_SMOOTH);
	 * 
	 * String filename = multipartFile.getOriginalFilename(); String ext =
	 * filename.substring(filename.lastIndexOf(".")+1);
	 * 
	 * BufferedImage newImage = new BufferedImage(295, 354,
	 * BufferedImage.TYPE_INT_RGB); ImageIO.write(newImage, ext, PATH+filename); }
	 */
	@GetMapping("/bbsList")
	public String getList(Model model) {
		model.addAttribute("list", service.getAll());
		return "/bbs/bbsList";
	}

	@GetMapping({ "/bbsGet" })
	public String get(Model model, @RequestParam int bno) {
//		FileVO fileVo = fileService.findByBno(bno);

		model.addAttribute("bbs", service.get(bno));
		model.addAttribute("fileVo", fileService.findByBno(bno));
		model.addAttribute("eduVo", eduService.findByBno(bno));

		System.out.println("bbs Get fileVo : " + bno);
		return "/bbs/bbsGet";
	}
//	@GetMapping(
//			  value = "/get-image-with-media-type",
//			  produces = MediaType.IMAGE_JPEG_VALUE
//			)
//			public @ResponseBody byte[] getImageWithMediaType() throws IOException {
//			    InputStream in = getClass()
//			      .getResourceAsStream("/com/baeldung/produceimage/image.jpg");
//			    return IOUtils.toByteArray(in);
//			}

	@GetMapping(value = "/ViewImage")
	public ResponseEntity<byte[]> viewImage(Model model, @RequestParam int bno) throws IOException {
		System.out.println("viewImage : " + bno);
		model.addAttribute("bno", bno);
		FileVO vo = fileService.findByBno(bno);

		File file = new File(PATH + vo.getFilename());
		/*
		 * Image image = ImageIO.read(file); Image resizeImage =
		 * image.getScaledInstance(295 , 354, Image.SCALE_SMOOTH);
		 * 
		 * BufferedImage newImage = new BufferedImage(295, 354,
		 * BufferedImage.TYPE_INT_RGB); Graphics g = newImage.getGraphics();
		 * g.drawImage(resizeImage, 0, 0, null); g.dispose();
		 * 
		 * ImageIO.write(newImage, "png", new File(vo.getPath()+vo.getFilename()));
		 */

		FileInputStream fis = new FileInputStream(file);
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		int data = 0;

		while ((data = fis.read()) != -1) {
			baos.write(data);
		}

//		FileItem fileItem = null;
//		try {
//			fileItem = new DiskFileItem("mainFile", Files.probeContentType(file.toPath()), false, file.getName(),
//					(int) file.length(), file.getParentFile());
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		;
//
//		try {
//			InputStream input = new FileInputStream(file);
//			OutputStream os = fileItem.getOutputStream();
//			IOUtils.copy(input, os);
//			// Or faster..
//			// IOUtils.copy(new FileInputStream(file), fileItem.getOutputStream());
//		} catch (IOException ex) {
//			// do something.
//		}
//
//		MultipartFile multipartFile = new CommonsMultipartFile(fileItem);
//		
//		System.out.println(multipartFile.getBytes());

		System.out.println(baos.toByteArray());

		fis.close();
		baos.close();

		return new ResponseEntity<byte[]>(baos.toByteArray(), HttpStatus.OK);
	}

	@PostMapping("/remove")
	public String remove(int bno) {

		if (fileService.findByBno(bno) != null) {
			fileService.removeFile(bno);
		}

		if (eduService.findByBno(bno) != null) {
			eduService.removeEdu(bno);
		}
		service.remove(bno);

		return "redirect:/bbsList";
	}

	@GetMapping("/modify")
	public String modify(Model model, int bno) {
		model.addAttribute("bbs", service.get(bno));
		model.addAttribute("fileVo", fileService.findByBno(bno));
		model.addAttribute("eduVo", eduService.findByBno(bno));

		return "/bbs/modify";
	}

	@PostMapping("/modify")
	public String modify(BbsVO vo, RedirectAttributes ra, EduVO eduVo) {
		// vo = new BbsVO();
		service.modify(vo);

		ra.addAttribute("bno", vo.getBno());
		vo.setEduVo(eduVo);
		eduVo.setBno(vo.getBno());
		/*
		 * if(eduVo != null) { eduService.removeByFno(eno); }
		 */
		return "redirect:/bbsList";
	}

	@PostMapping("/removeList")
	public String removeList(@RequestParam("chbox[]") List<String> chArr) {
//		List<BbsVO> list = new ArrayList<BbsVO>();
		BbsVO vo = new BbsVO();

//		list.add(service.get(bno));

//		service.removeList(list);

		for (String str : chArr) {
			System.out.println(str);
			int chNum = Integer.parseInt(str);
			vo = service.get(chNum);
//			vo.setBno(chNum);
			service.removeList(vo.getBno());
		}

		return "redirect:/bbsList";
	}

	@PostMapping("/removeByEno")
	@ResponseBody
	public void removeByEno(int eno) {
		eduService.removeByEno(eno);
	}

	@PostMapping("/pictureUpload")
	public void pictureUpload(MultipartHttpServletRequest request) {
		PictureVO vo = new PictureVO();
		MultipartFile file = request.getFile("picture");

		try {
			vo.setPicture(file.getBytes());
			vo.setBno(service.bnoVal());

			pictureService.insert(vo);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

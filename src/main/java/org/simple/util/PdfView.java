package org.simple.util;

import java.io.File;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.AbstractView;

import com.itextpdf.text.pdf.PdfWriter;

public class PdfView extends AbstractView{
	
	private final static String PATH = "G:"+File.separator+"upload"+File.separator;
	

	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		response.setHeader("Content-Disposition", "attachment; filename="+PATH);
		
		
	}
	
	

}

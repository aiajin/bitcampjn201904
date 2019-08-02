package com.bitcamp.mvc.member;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.bitcamp.mvc.domain.Report;

@Controller
public class FileUploadController {
	
	@RequestMapping("/fileupload/uploadForm")
	public String getForm() {
		return "fileupload/uploadForm";
	}

	@RequestMapping(value = "/fileupload/upload1", method = RequestMethod.POST)
	public String upload1(
			@RequestParam("sno") String sno,
			@RequestParam("report") MultipartFile file,
			Model model
			) {
		
		model.addAttribute("sno", sno);
		model.addAttribute("fileName", file.getOriginalFilename());
		model.addAttribute("fileSize", file.getSize());
		
		return "fileupload/upload";
	}

	@RequestMapping(value = "/fileupload/upload2", method = RequestMethod.POST)
	public String upload1(
			MultipartHttpServletRequest request,
			Model model
			) {
		
		String sno = request.getParameter("sno");
		MultipartFile file = request.getFile("report");
		
		model.addAttribute("sno", sno);
		model.addAttribute("fileName", file.getOriginalFilename());
		model.addAttribute("fileSize", file.getSize());
		
		return "fileupload/upload";
	}

	@RequestMapping(value = "/fileupload/upload3", method = RequestMethod.POST)
	public String upload1(Report report) {
		
		return "fileupload/upload";
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}

package com.bitcamp.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SecurityController {
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@ResponseBody
	@RequestMapping("/encodepassword")
	public String bcript() {
		
		String str = "password";
		
		String encodingStr = encoder.encode(str);
		
		boolean result = encoder.matches(str, encodingStr);
		
		return str + " : " + encodingStr + "<br>"
				+ "str=encodingStr ==> "+ result;
		
	}
	

	@ResponseBody
	@RequestMapping("/encodepassword1")
	public String bcript1() {
		
		String str = "password";		
		String encodingStr = Sha256.encrypt(str);
		String pw = "password";
		boolean result = encodingStr.equals(Sha256.encrypt(pw));
		
		return str + " : " + encodingStr + "<br>"
				+ "encodingStr = pw ==> " + result ;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}

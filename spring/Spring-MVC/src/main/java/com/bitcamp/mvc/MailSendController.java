package com.bitcamp.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MailSendController {
	
	@Autowired
	MailSender sender;  
	
	
	@ResponseBody
	@RequestMapping("/mail/send")
	public String sendMail() {
		
		// 메일 내용 설정
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo("ryuyj76@naver.com");
		message.setSubject("처음 보내는 Java Mail 입니다.");
		message.setText("처음 보내는 메일의 내용입니다. 반갑습니다.");
		message.setFrom("ryuyj@nate.com");
		
		sender.send(message);
		
		
		return "send Ok";
	}

	
	
	
	
	
	
	
	
}

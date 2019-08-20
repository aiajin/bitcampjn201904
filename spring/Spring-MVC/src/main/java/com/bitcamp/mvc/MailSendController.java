package com.bitcamp.mvc;

import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

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
	
	@Autowired
	JavaMailSender javaMailSender;
	
	
	@ResponseBody
	@RequestMapping("/mail/send")
	public String sendMail() {
		
		// 메일 내용 설정
		SimpleMailMessage message = new SimpleMailMessage();
		
		message.setTo("ryuyj76@naver.com");
		message.setSubject("처음 보내는 Java Mail 입니다.");
		message.setText("처음 보내는 메일의 내용입니다. 반갑습니다.");
		message.setFrom("ryuyj@nate.com");
		
		SimpleMailMessage m = new SimpleMailMessage(message);
		
		sender.send(message);
		
		
		return "send Ok";
	}
	
	@RequestMapping("/mail/send2")
	public String sendJavaMailSender() {
		
		MimeMessage message = javaMailSender.createMimeMessage();
		
		try {
			// 메일 제목 설정
			message.setSubject("[안내] 처음 보내는 JavaMailSender", "UTF-8");
			
			// html 메일 내용
			String htmlStr = "<h1 style=\"color:blue\">안녕하세요</h1><br>"
					+ "<a href=\"http://www.naver.com\">naver</a>";
			// 내용 설정
			message.setText(htmlStr, "UTF-8", "html");
			// To 설정
			message.addRecipient(
					RecipientType.TO, 
					new InternetAddress("ryuyj76@naver.com", "유영진 님", "UTF-8"));
			
			javaMailSender.send(message);
			
			
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return "send ok";
	}

	
	
	
	
	
	
	
	
}

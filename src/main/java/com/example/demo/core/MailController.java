package com.example.demo.core;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.mail.MailSender;
import com.example.demo.mail.MockMailSender;

@RestController
public class MailController {
	
	//@Resource
	private MailSender mailSender;
	
	@Autowired
	public MailController(@Qualifier("smtpMailSender") MailSender mailSender) {
		this.mailSender = mailSender;
	}
	
	@RequestMapping("/mail")
	public String sendMail() {
		mailSender.send("abc@example.com", "some subject", "some content");
		return "Mail Sent";
	}
	
}

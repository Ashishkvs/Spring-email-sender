package com.email.controller;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
public class SendEmail {
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	
	public void send(String to,String subject,String body) throws MessagingException{
		MimeMessage message=javaMailSender.createMimeMessage();
		MimeMessageHelper helper;
		helper=new MimeMessageHelper(message, true); //true indicates multipart message
		helper.setSubject(subject);
		helper.setTo(to);
		helper.setText(body,true);//true indicates html we cann add attachment
		javaMailSender.send(message);
		
	}
}

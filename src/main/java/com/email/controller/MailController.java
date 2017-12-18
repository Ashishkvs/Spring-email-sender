package com.email.controller;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MailController {
	@Autowired
	private SendEmail sendEmail;

	@RequestMapping("/mail")
	public String sendMail()throws MessagingException{
		sendEmail.send("ashishkvs@gmail.com", "Test mail from spring", "hello there");
		return "mail Sent Successfully !";
	}
}

package com.nxtc.nps.delivery.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {

	@Autowired
	private JavaMailSender javaMailSender;

	@Override
	public String sendEmail(String recepient, String subject, String messageBody) {
		SimpleMailMessage msg = new SimpleMailMessage();
		msg.setTo(recepient);
		msg.setSubject(subject);
		msg.setText(messageBody);

		javaMailSender.send(msg);

		return "success";
	}

}

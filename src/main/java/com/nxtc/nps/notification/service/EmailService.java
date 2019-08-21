package com.nxtc.nps.notification.service;

public interface EmailService {
	public String sendEmail(String recepient, String subject, String messageBody);
}

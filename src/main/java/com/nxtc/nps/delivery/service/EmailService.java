package com.nxtc.nps.delivery.service;

public interface EmailService {
	public String sendEmail(String recepient, String subject, String messageBody);
}

package com.nxtc.nps.notification.model;

import java.util.List;

public class NotificationTable {
	private String firstName;
	private String lastName;
	private String email;
	private List<String> notificationItem;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<String> getNotificationItem() {
		return notificationItem;
	}

	public void setNotificationItem(List<String> notificationItem) {
		this.notificationItem = notificationItem;
	}

}
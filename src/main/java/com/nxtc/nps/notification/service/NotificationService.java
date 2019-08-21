package com.nxtc.nps.notification.service;

import com.nxtc.nps.notification.model.NotificationTable;

public interface NotificationService {
	public String insertNotificationDetail(NotificationTable notification, String shipmentId);

}

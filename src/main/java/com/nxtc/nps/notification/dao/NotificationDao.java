package com.nxtc.nps.notification.dao;

import com.nxtc.nps.notification.model.NotificationTable;

public interface NotificationDao {
	public String insertNotificationDetail(NotificationTable notification, String shipmentId);

}

package com.nxtc.nps.notification.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nxtc.nps.notification.dao.NotificationDao;
import com.nxtc.nps.notification.model.NotificationTable;

@Service
public class NotificationServiceImp implements NotificationService {
	@Autowired
	NotificationDao deliveryDao;

	@Override
	public String insertNotificationDetail(NotificationTable notification, String shipmentId) {

		return deliveryDao.insertNotificationDetail(notification, shipmentId);
	}

}

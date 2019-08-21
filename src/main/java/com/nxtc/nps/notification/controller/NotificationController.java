package com.nxtc.nps.notification.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.nxtc.nps.notification.model.NotificationTable;
import com.nxtc.nps.notification.service.NotificationService;

@Controller
public class NotificationController {
	@Autowired
	NotificationService deliveryService;

	@RequestMapping(value = "/insertNotificationDetail", method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody String insertNotificationDetail(HttpServletResponse response,
			@RequestBody NotificationTable notification, @RequestParam String shipmentId) {
		return deliveryService.insertNotificationDetail(notification, shipmentId);
	}

}

package com.nxtc.nps.tracking.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nxtc.nps.tracking.model.TrackingHistory;
import com.nxtc.nps.tracking.service.TrackingHistoryService;

@Controller
public class TrackingController {
	@Autowired
	TrackingHistoryService trackingHistoryService;

	@RequestMapping(value = "/addTrackingHistory", method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody String addTrackingHistory(HttpServletResponse response, @RequestParam String shipmentId,
			@RequestBody TrackingHistory trackingHistory) {
		return trackingHistoryService.addTrackingHistory(shipmentId, trackingHistory);
	}
	
	@RequestMapping (value="/getTrackingHistoryByShipmentId", method = RequestMethod.GET, produces ="application/json")
	public @ResponseBody List<TrackingHistory> getTrackingHistory (HttpServletResponse response, @RequestParam String shipmentId )
	{
		return trackingHistoryService.getTrackingHistoryByShipmentId(shipmentId);
	}

}


package com.nxtc.nps.tracking.service;

import java.util.List;

import com.nxtc.nps.tracking.model.TrackingHistory;

public interface TrackingHistoryService {
	public String addTrackingHistory(String shipmentId ,TrackingHistory trackingHistory);
	public List<TrackingHistory> getTrackingHistoryByShipmentId(String shipmentId);
	

}

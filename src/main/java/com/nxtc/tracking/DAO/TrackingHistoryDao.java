package com.nxtc.tracking.DAO;

import java.util.List;

import com.nxtc.nps.tracking.model.TrackingHistory;

public interface TrackingHistoryDao {
	public String addTrackingHistory(String shipmentId, TrackingHistory trackingHistory);
	public List<TrackingHistory> getTrackingHistoryByShipmentId (String shipmentId);

}

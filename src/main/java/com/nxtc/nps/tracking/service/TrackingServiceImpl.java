package com.nxtc.nps.tracking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nxtc.nps.tracking.DAO.TrackingHistoryDao;
import com.nxtc.nps.tracking.model.TrackingHistory;
@Service

public class TrackingServiceImpl implements TrackingHistoryService {
	@Autowired
	TrackingHistoryDao trackingHistoryDao;

	@Override
	public String addTrackingHistory(String shipmentId, TrackingHistory trackingHistory) {
		
		return trackingHistoryDao.addTrackingHistory(shipmentId, trackingHistory) ;
	}

	@Override
	public List<TrackingHistory> getTrackingHistoryByShipmentId(String shipmentId) {
		
		return trackingHistoryDao.getTrackingHistoryByShipmentId(shipmentId) ;
	}

}

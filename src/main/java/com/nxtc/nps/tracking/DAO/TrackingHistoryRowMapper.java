package com.nxtc.nps.tracking.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;

import com.nxtc.nps.tracking.model.TrackingHistory;

public class TrackingHistoryRowMapper implements RowMapper<TrackingHistory> {

	@Override
	public TrackingHistory mapRow(ResultSet rs, int rowNum) throws SQLException {
		TrackingHistory tracking = new  TrackingHistory(); 
		tracking.setTrackMessage(rs.getString("track_message"));
		tracking.setShipmentId(rs.getString("shipment_id"));
		tracking.setTrackDate(rs.getDate("track_date"));
		tracking.setStatus(rs.getString("status_message"));
		return tracking;
	}

}

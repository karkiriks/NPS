package com.nxtc.nps.tracking.DAO;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.nxtc.nps.tracking.model.TrackingHistory;

@Repository
public class TrackingHistoryDaoImp implements TrackingHistoryDao {
	@Autowired
	DataSource dataSource;
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public String addTrackingHistory(String shipmentId, TrackingHistory trackingHistory) {

		jdbcTemplate = new JdbcTemplate(dataSource);
		StringBuilder addQuery = new StringBuilder();
		addQuery.append("insert into tracking_history (track_message , track_date , shipment_id) values (?,now(),?)");
		try {
			jdbcTemplate.update(addQuery.toString(), new Object[] { trackingHistory.getTrackMessage(), shipmentId });
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "failure";
	}

	@Override
	public List<TrackingHistory> getTrackingHistoryByShipmentId(String shipmentId) {
		List<TrackingHistory> trackingList = new ArrayList<TrackingHistory>();
		jdbcTemplate = new JdbcTemplate(dataSource);
		StringBuilder getQuery = new StringBuilder();
		getQuery.append(
				"select sh.shipment_id, th.track_message, th.track_date, ss.status_message from shipment sh, shipment_status ss, tracking_history th "
						+ "where sh.shipment_id = ?" + "and ss.status_id = sh.status_id "
						+ "and th.shipment_id = sh.shipment_id order by th.track_date desc; ");
		try {
			trackingList = jdbcTemplate.query(getQuery.toString(), new Object[] { shipmentId },
					new TrackingHistoryRowMapper());
			return trackingList;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
}

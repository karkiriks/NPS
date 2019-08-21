package com.nxtc.nps.notification.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.nxtc.nps.notification.model.NotificationInfo;

public class NotificationInfoRowMapper implements RowMapper<NotificationInfo> {

	@Override
	public NotificationInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
		NotificationInfo info = new NotificationInfo();

		info.setFirstName(rs.getString("first_name"));
		info.setLastName(rs.getString("last_name"));
		info.setEmail(rs.getString("email"));
		info.setStatusMessage(rs.getString("status_message"));
		info.setShipmentId(rs.getString("shipment_id"));
		return info;

	}

}

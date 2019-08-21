package com.nxtc.nps.notification.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.nxtc.nps.notification.model.NotificationTable;

public class NotificationRowMapper implements RowMapper<NotificationTable> {

	@Override
	public NotificationTable mapRow(ResultSet rs, int rowNum) throws SQLException {
		NotificationTable pd = new NotificationTable();

		pd.setFirstName(rs.getString("first_name"));
		pd.setLastName(rs.getString("last_name"));
		pd.setEmail(rs.getString("email"));
		return pd;
	}

}

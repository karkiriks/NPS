package com.nxtc.nps.delivery.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.nxtc.nps.delivery.model.ProofOfDelivery;

public class ProofOfDeliveryRowMapper implements RowMapper<ProofOfDelivery>{

	@Override
	public ProofOfDelivery mapRow(ResultSet rs, int rowNum) throws SQLException {
		ProofOfDelivery pd = new ProofOfDelivery();
		
		pd.setFirstName(rs.getString("first_name"));
		pd.setLastName(rs.getString("last_name"));
		pd.setEmail(rs.getString("email"));
		return pd;
	}

}

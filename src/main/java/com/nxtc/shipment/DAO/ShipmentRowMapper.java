package com.nxtc.shipment.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.nxtc.shipment.model.Shipment;
import com.nxtc.shipment.model.Shipper;

public class ShipmentRowMapper implements RowMapper<Shipment> {
    
	@Override
	public Shipment mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Shipment shipment = new Shipment();
		Shipper fromshipper = new Shipper();
		Shipper toShipper = new Shipper();
		
		shipment.setShipmentId(rs.getInt("shipment_id"));
		shipment.setShipmentCharge(rs.getDouble("shipment_charge"));
		shipment.setShipmentWeight(rs.getDouble("shipment_weight"));
		shipment.setStatus(rs.getString("status_message"));
		
		fromshipper.setFirstName(rs.getString("from_first_name"));
		fromshipper.setLastName(rs.getString("from_last_name"));
		fromshipper.setPhoneNumber(rs.getString("from_phone_number"));
		fromshipper.setStreetName(rs.getString("from_street"));
		fromshipper.setCity(rs.getString("from_city"));
		fromshipper.setState(rs.getString("from_state"));
		fromshipper.setZipCode(rs.getString("from_zipcode"));
		
		toShipper.setFirstName(rs.getString("to_first_name"));
		toShipper.setLastName(rs.getString("to_last_name"));
		toShipper.setPhoneNumber(rs.getString("to_phone_number"));
		toShipper.setStreetName(rs.getString("to_street"));
		toShipper.setCity(rs.getString("to_city"));
		toShipper.setState(rs.getString("to_state"));
		toShipper.setZipCode(rs.getString("to_zipcode"));

		shipment.setFromShipper(fromshipper);
		shipment.setToShipper(toShipper);
		return shipment ;
	}

}

package com.nxtc.shipment.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;

import com.nxtc.shipment.model.Address;
import com.nxtc.shipment.model.Shipment;
import com.nxtc.shipment.model.Shipper;

public class ShipmentRowMapper implements RowMapper {
    
	@Override
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Shipment shipment = new Shipment();
		Shipper fromshipper = new Shipper();
		Shipper toShipper = new Shipper();
		Address fromAddress = new Address();
		Address toAddress = new Address();
		shipment.setShipmentId(rs.getInt("shipment_id"));
		shipment.setShipmentCharge(rs.getDouble("shipment_charge"));
		shipment.setShipmentWeight(rs.getDouble("shipment_weight"));
		
		fromshipper.setFirstName(rs.getString("from_first_name"));
		fromshipper.setLastName(rs.getString("from_last_name"));
		fromshipper.setPhoneNumber(rs.getString("from_phone_number"));
		
		toShipper.setFirstName(rs.getString("to_first_name"));
		toShipper.setLastName(rs.getString("to_last_name"));
		toShipper.setPhoneNumber(rs.getString("to_phone_number"));
		
		fromAddress.setStreetAddress(rs.getString("from_street_address"));
		//fromAddress.setAddressId(rs.getInt("address_id"));
		fromAddress.setCity(rs.getString("from_city"));
		fromAddress.setState(rs.getString("from_state"));
		fromAddress.setZipCode(rs.getString("from_zipcode"));
		
		toAddress.setStreetAddress(rs.getString("to_street_address"));
	//	toAddress.setAddressId(rs.getInt("address_id"));
		toAddress.setCity(rs.getString("to_city"));
		toAddress.setState(rs.getString("to_state"));
		toAddress.setZipCode(rs.getString("to_zipcode"));
		
		fromshipper.setAddress(fromAddress);
		toShipper.setAddress(toAddress);
		
		shipment.setFromShipper(fromshipper);
		shipment.setToShipper(toShipper);
		return shipment ;
	}

}

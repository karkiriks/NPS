package com.nxtc.shipment.DAO;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.nxtc.shipment.model.Shipment;

@Repository
public class ShipmentDaoImp implements ShipmentDao {
	private static final String String = null;
	@Autowired
	DataSource dataSource;
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	

	@Override
	public Shipment getShipmentById(int shipmentId) throws Exception {
		//Shipment shipment = new Shipment();
		List<Shipment> shipmentList = new ArrayList<Shipment>();
		jdbcTemplate = new JdbcTemplate(dataSource);
		
		StringBuilder selectQuery = new StringBuilder();
		selectQuery.append(" select distinct(sh.shipment_id), sh.shipment_weight, sh.shipment_charge , ss.status_message, " + 
				 
				" fromshipper.first_name as from_first_name , " + 
				" fromshipper.last_name as from_last_name, " + 
				" fromshipper.phone_number as from_phone_number," + 
				" fromaddr.street_address as from_street_address, " + 
				" fromaddr.city as from_city, " + 
				" fromaddr.state as from_state, " + 
				" fromaddr.zipcode as from_zipcode, " + 
				  
				" toshipper.first_name as to_first_name, " + 
				" toshipper.last_name as to_last_name, " + 
				" toshipper.phone_number as to_phone_number, " + 
				" toaddr.street_address as to_street_address, " + 
				" toaddr.city as to_city, " + 
				" toaddr.state as to_state, " + 
				" toaddr.zipcode as to_zipcode" + 
				
				" from shipment sh , " + 
				" shipper fromshipper, shipper toshipper, " + 
				" address fromaddr, address toaddr " + ", shipment_status as ss  " +
				" where sh.shipment_id =  ?" + 
				" and sh.from_shipper = fromshipper.shipper_id " + 
				" and sh.to_shipper = toshipper.shipper_id " + 
				" and fromshipper.address_id = fromaddr.address_id " + 
				" and toshipper.address_id = toshipper.address_id and sh.status_id = ss.status_id limit 1;");
		
		try 
		{
			shipmentList = jdbcTemplate.query(selectQuery.toString(), new Object[] {shipmentId}, new ShipmentRowMapper());
		}catch(Exception e)
		{
			e.getMessage();
		}
		
		if(shipmentList.size()>0) {
			return shipmentList.get(0);
		}else
		{
			return new Shipment();
		}
		
	}
	@Override
	public List<String> getStatusMessage() {
		List<String> statusList = new ArrayList<>();
	    jdbcTemplate = new JdbcTemplate(dataSource);
	    StringBuilder selectQuery = new StringBuilder();
	    selectQuery.append("select status_message from shipment_status;");
	    try
	    {
	    statusList=	jdbcTemplate.queryForList(selectQuery.toString(), String.class);
	    }catch (Exception e) {
			// TODO: handle exception
	    	e.getMessage();
		}
		return statusList;
	}
	@Override
	public String updateShipmentStatus(int shipmentId, String statusMessage) {
		jdbcTemplate = new JdbcTemplate(dataSource);
		StringBuilder updateQuery = new StringBuilder();
		int a=0;
		updateQuery.append("update shipment set status_id = (select status_id from shipment_status where status_message = ? ) where shipment_id = ?;");
		
		try
		{
		//	System.out.println(update shipment set status_id = (select status_id from shipment_status where status_message = pending pickup  ) where shipment_id = 10001;);
			 a = jdbcTemplate.update(updateQuery.toString(),new Object[] {statusMessage, shipmentId});
		}catch (Exception e) {
			e.getMessage();
		}
		return +a+ "row updated";
	}
	
	

}

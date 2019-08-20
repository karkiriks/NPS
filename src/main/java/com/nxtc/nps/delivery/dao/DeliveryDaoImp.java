package com.nxtc.nps.delivery.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.nxtc.nps.delivery.model.ProofOfDelivery;


@Repository
public class DeliveryDaoImp implements DeliveryDao {
	@Autowired
	JdbcTemplate JdbcTemplate;
	@Autowired
	DataSource dataSource;
	@Override
	public String insertDeliveryDetail(ProofOfDelivery proofOfDelivery, String shipmentId) {
		JdbcTemplate = new JdbcTemplate(dataSource);
		StringBuilder insertQuery = new StringBuilder();
		insertQuery.append("insert into delivery_table (`first_name`,`last_name`,`email`,shipment_id ) values (?,?,?,?)");
		try
		{
		int rows =JdbcTemplate.update(insertQuery.toString(), new Object[] {proofOfDelivery.getFirstName(), proofOfDelivery.getLastName(), proofOfDelivery.getEmail(),shipmentId});
		if(rows>0)
		{
			return "Success" + rows+ "updated";
		}
		}catch (Exception e) {
			e.printStackTrace();
		}
	
		return "failure";
	}

}

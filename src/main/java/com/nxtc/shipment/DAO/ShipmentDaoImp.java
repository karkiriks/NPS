package com.nxtc.shipment.DAO;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.nxtc.nps.tracking.model.TrackingHistory;
import com.nxtc.shipment.model.Shipment;
import com.nxtc.shipment.model.Shipper;

@Repository
public class ShipmentDaoImp implements ShipmentDao {

	@Autowired
	DataSource dataSource;
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public Shipment getShipmentById(String shipmentId) throws Exception {
		Shipment shipment = new Shipment();
		List<Shipment> shipmentList = new ArrayList<Shipment>();
		jdbcTemplate = new JdbcTemplate(dataSource);

		StringBuilder selectQuery = new StringBuilder();
		selectQuery.append("select sh.shipment_id, sh.shipment_weight, sh.shipment_charge, ss.status_message, "
				+ "fromshipper.first_name as from_first_name,  " + "fromshipper.last_name as from_last_name, "
				+ "fromshipper.phone_number as from_phone_number,  " + "fromshipper.street as from_street, "
				+ "fromshipper.city as from_city, " + "fromshipper.state as from_state, "
				+ "fromshipper.zipcode as from_zipcode, " + "toshipper.first_name as to_first_name, "
				+ "toshipper.last_name as to_last_name,  " + "toshipper.phone_number as to_phone_number, "
				+ "toshipper.street as to_street, " + "toshipper.city as to_city, " + "toshipper.state as to_state, "
				+ "toshipper.zipcode as to_zipcode "
				+ "from shipment sh, shipper fromshipper, shipper toshipper, shipment_status ss "
				+ "where sh.shipment_id = ? " + "and sh.from_shipper = fromshipper.shipper_id "
				+ "and sh.to_shipper = toshipper.shipper_id " + "and sh.status_id = ss.status_id limit 1");

		try {
			shipmentList = jdbcTemplate.query(selectQuery.toString(), new Object[] { shipmentId },
					new ShipmentRowMapper());
		} catch (Exception e) {
			e.getMessage();
		}

		if (shipmentList.size() == 1) {
			return shipmentList.get(0);
		} else {
			return new Shipment();
		}

	}

	@Override
	public List<String> getStatusMessage() {
		List<String> statusList = new ArrayList<>();
		jdbcTemplate = new JdbcTemplate(dataSource);
		StringBuilder selectQuery = new StringBuilder();
		selectQuery.append("select status_message from shipment_status;");
		try {
			statusList = jdbcTemplate.queryForList(selectQuery.toString(), String.class);
		} catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
		}
		return statusList;
	}

	@Override
	public String updateShipmentStatus(int shipmentId, String statusMessage) {
		jdbcTemplate = new JdbcTemplate(dataSource);
		StringBuilder updateQuery = new StringBuilder();
		int a = 0;
		updateQuery.append(
				"update shipment set status_id = (select status_id from shipment_status where status_message = ? ) where shipment_id = ?;");

		try {
			// System.out.println("update shipment set status_id = (select status_id from
			// shipment_status where status_message = pending pickup ) where shipment_id =
			// 10001;);
			a = jdbcTemplate.update(updateQuery.toString(), new Object[] { statusMessage, shipmentId });
		} catch (Exception e) {
			e.getMessage();
		}
		return +a + "row updated";
	}

	@Override
	public String updateShipperInfo(Shipper shipper, int shipmentId, String shipperType) {
		// Shipper shipper = new Shipper();
		NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
		StringBuilder updateQuery = new StringBuilder();
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		updateQuery.append(
				"update shipper set first_name = :firstName ,last_name = :lastName ,phone_number = :phoneNumber, street = :streetName, "
						+ "city = :city, state = :state , zipcode = :zipcode " + "where shipper_id = (select ");
		if (shipperType.equalsIgnoreCase("fromshipper")) {
			updateQuery.append(" from_shipper ");
		} else {
			updateQuery.append(" to_shipper ");
		}

		updateQuery.append(" from shipment where shipment_id = :shipmentId)");
		parameters.addValue("firstName", shipper.getFirstName());
		parameters.addValue("lastName", shipper.getLastName());
		parameters.addValue("phoneNumber", shipper.getPhoneNumber());
		parameters.addValue("streetName", shipper.getStreetName());
		parameters.addValue("city", shipper.getCity());
		parameters.addValue("state", shipper.getState());
		parameters.addValue("zipcode", shipper.getZipCode());
		parameters.addValue("shipmentId", shipmentId);
		try {
			int updatedRows = namedParameterJdbcTemplate.update(updateQuery.toString(), parameters);
			if (updatedRows > 0) {
				return "success";
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "failure";
	}

	public String addShipment(Shipment shipment) {
		jdbcTemplate = new JdbcTemplate(dataSource);
		StringBuilder insertShipper = new StringBuilder();
		StringBuilder insertShipment = new StringBuilder();
		// StringBuilder insertShipmentStatus= new StringBuilder();
		insertShipper.append(
				"insert into shipper(`first_name`,`last_name`,`phone_number`,`street`,`city`,`state`,`zipcode`,`create_date`) values (?,?,?,?,?,?,?,curdate())");
		StringBuilder queryForId = new StringBuilder();
		queryForId.append(" select last_insert_id() limit 1 ; ");
		shipment.setShipmentId(getshipmentId());
		int toShipperId = 0;
		int fromShipperId = 0;

		try {
			jdbcTemplate.update(insertShipper.toString(),
					new Object[] { shipment.getFromShipper().getFirstName(), shipment.getFromShipper().getLastName(),
							shipment.getFromShipper().getPhoneNumber(), shipment.getFromShipper().getStreetName(),
							shipment.getFromShipper().getCity(), shipment.getFromShipper().getState(),
							shipment.getFromShipper().getZipCode() });

			fromShipperId = jdbcTemplate.queryForObject(queryForId.toString(), Integer.class);

			jdbcTemplate.update(insertShipper.toString(),
					new Object[] { shipment.getToShipper().getFirstName(), shipment.getToShipper().getLastName(),
							shipment.getToShipper().getPhoneNumber(), shipment.getToShipper().getStreetName(),
							shipment.getToShipper().getCity(), shipment.getToShipper().getState(),
							shipment.getToShipper().getZipCode() });

			toShipperId = jdbcTemplate.queryForObject(queryForId.toString(), Integer.class);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		insertShipment.append(
				"insert into shipment(`shipment_id`,`from_shipper`,`to_shipper`,`shipment_weight`,`shipment_charge`,`create_date`) values(?,?,?,?,?,curdate())");

		try {
			int rows = jdbcTemplate.update(insertShipment.toString(), new Object[] { shipment.getShipmentId(),
					fromShipperId, toShipperId, shipment.getShipmentWeight(), shipment.getShipmentCharge() });
			if (rows > 0) {

				return " " + "shipment with ID :" + shipment.getShipmentId() + " was created";

			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return "Failure";
	}

	@Override
	public String updateShipmentById(int shipmentId, Shipment shipment) {

		NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		StringBuilder updateQuery = new StringBuilder();
		updateQuery.append(
				"update shipment set shipment_weight= :shipmentWeight , shipment_charge = :shipmentCharge where shipment_id = "
						+ shipmentId + ";");
		parameters.addValue("shipmentWeight", shipment.getShipmentWeight());
		parameters.addValue("shipmentCharge", shipment.getShipmentCharge());
		try {
			int rows = namedParameterJdbcTemplate.update(updateQuery.toString(), parameters);
			if (rows > 0) {
				return "success" + "" + rows + "updated";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "failure";
	}

	public String getshipmentId() {
		long epochTime = 0;
		Date today = Calendar.getInstance().getTime();
		SimpleDateFormat dateFormat = new SimpleDateFormat("MMM dd yyyy HH:mm:ss.SSS zzz");
		String currentTime = dateFormat.format(today);
		try {
			Date date = dateFormat.parse(currentTime);
			epochTime = date.getTime();
			return "" + epochTime;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "" + epochTime;

	}

	/**
	 *
	 */
	

}

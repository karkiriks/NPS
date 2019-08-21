package com.nxtc.nps.notification.dao;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.nxtc.nps.notification.model.NotificationTable;
import com.nxtc.nps.shipment.DAO.ShipmentDaoImp;

@Repository
public class NotificationDaoImp implements NotificationDao {
	@Autowired
	JdbcTemplate JdbcTemplate;
	@Autowired
	DataSource dataSource;
	@Autowired
	ShipmentDaoImp shipmentDaoImp;

	@Override
	public String insertNotificationDetail(NotificationTable notificationTable, String shipmentId) {
		JdbcTemplate = new JdbcTemplate(dataSource);

		System.out.println(notificationTable.getNotificationItem().size());
		for (String Item : notificationTable.getNotificationItem()) {
			StringBuilder insertQuery = new StringBuilder();
			insertQuery.append(
					"insert into notification_table (`first_name`,`last_name`,`email`, shipment_id, status_id) values (?,?,?,?,(select  status_id from shipment_status where status_message = ?));");

			try {

				JdbcTemplate.update(insertQuery.toString(), new Object[] { notificationTable.getFirstName(),
						notificationTable.getLastName(), notificationTable.getEmail(), shipmentId, Item });
			} catch (Exception e) {
				e.printStackTrace();
				return "failure";
			}
		}

		return "success";
	}

}

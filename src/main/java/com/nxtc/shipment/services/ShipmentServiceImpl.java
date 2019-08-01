package com.nxtc.shipment.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nxtc.shipment.DAO.ShipmentDao;
import com.nxtc.shipment.model.Shipment;

@Service
public class ShipmentServiceImpl implements ShipmentService {

	@Autowired 
	ShipmentDao shipmentDao;
	@Override
	public Shipment getShipmentById(int shipmentId) throws Exception {
		return shipmentDao.getShipmentById(shipmentId);
	}


}

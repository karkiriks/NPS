package com.nxtc.shipment.services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nxtc.shipment.DAO.ShipmentDao;
import com.nxtc.shipment.model.Shipment;
import com.nxtc.shipment.model.Shipper;

@Service
public class ShipmentServiceImpl implements ShipmentService {

	@Autowired 
	ShipmentDao shipmentDao;
	@Override
	public Shipment getShipmentById(int shipmentId) throws Exception {
		return shipmentDao.getShipmentById(shipmentId);
	}
	@Override
	public List<String> getStatusMessage() {
		// TODO Auto-generated method stub
		return shipmentDao.getStatusMessage() ;
	}
	
	public String updateShipmentStatus(int shipmentId, String statusMessage) {
		
		return shipmentDao.updateShipmentStatus(shipmentId, statusMessage);
	}
	@Override
	public String updateShipperInfo(Shipper shipper, int shipmentId, String shipperType) {
		
		
		return shipmentDao.updateShipperInfo(shipper, shipmentId, shipperType);
	}



}

package com.nxtc.shipment.DAO;

import com.nxtc.shipment.model.Shipment;

public interface ShipmentDao {
	public Shipment getShipmentById (int shipmentId) throws Exception;
	
	

}

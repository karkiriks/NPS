package com.nxtc.shipment.services;

import com.nxtc.shipment.model.Shipment;


public interface ShipmentService {
	
	public Shipment getShipmentById (int shipmentId) throws Exception;
	

}

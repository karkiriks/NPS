package com.nxtc.shipment.services;

import java.util.List;

import com.nxtc.shipment.model.Shipment;


public interface ShipmentService {
	
	public Shipment getShipmentById (int shipmentId) throws Exception;
	public List<String> getStatusMessage();
	public String updateShipmentStatus( int  shipmentId, String statusMessae);
	

}

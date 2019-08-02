package com.nxtc.shipment.services;

import java.util.List;

import com.nxtc.shipment.model.Shipment;
import com.nxtc.shipment.model.Shipper;


public interface ShipmentService {
	
	public Shipment getShipmentById (int shipmentId) throws Exception;
	public List<String> getStatusMessage();
	public String updateShipmentStatus( int  shipmentId, String statusMessae);
	public String updateShipperInfo(Shipper shipper, int shipmentId, String shipperType);
	

}

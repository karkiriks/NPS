package com.nxtc.nps.shipment.services;

import java.util.List;

import com.nxtc.nps.shipment.model.Shipment;
import com.nxtc.nps.shipment.model.Shipper;
import com.nxtc.nps.tracking.model.TrackingHistory;


public interface ShipmentService {
	
	public Shipment getShipmentById (String shipmentId) throws Exception;
	public List<String> getStatusMessage();
	public String updateShipmentStatus(String  shipmentId, String statusMessae);
	public String updateShipperInfo(Shipper shipper, int shipmentId, String shipperType);
	public String addShipment(Shipment shipment);
	public String updateShipmentById(int shipmentID, Shipment shipment);
	
	
	

}

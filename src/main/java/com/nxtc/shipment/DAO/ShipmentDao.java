package com.nxtc.shipment.DAO;

import java.util.List;

import com.nxtc.shipment.model.Shipment;

public interface ShipmentDao {
	public Shipment getShipmentById (int shipmentId) throws Exception;
	public List<String> getStatusMessage();
	public String updateShipmentStatus(int shipmentId, String statusMessage);
	

}

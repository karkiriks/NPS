package com.nxtc.shipment.DAO;

import java.util.List;

import com.nxtc.shipment.model.Shipment;
import com.nxtc.shipment.model.Shipper;

public interface ShipmentDao {
	public Shipment getShipmentById (int shipmentId) throws Exception;
	public List<String> getStatusMessage();
	public String updateShipmentStatus(int shipmentId, String statusMessage);
	public String updateShipperInfo(Shipper shipper, int shipmentId, String shipperType);
	

}

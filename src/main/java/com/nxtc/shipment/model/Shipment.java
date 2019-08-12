package com.nxtc.shipment.model;

public class Shipment {
	private String shipmentId;
	private Shipper fromShipper;
	private Shipper toShipper;
	private double shipmentWeight;
	private double shipmentCharge;
	private String status;
	
	@Override
	public String toString() {
		return "Shipment [shipmentId=" + shipmentId + ", fromShipper=" + fromShipper + ", toShipper=" + toShipper
				+ ", shipmentWeight=" + shipmentWeight + ", shipmentCharge=" + shipmentCharge + ", status=" + status
				+ "]";
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getShipmentId() {
		return shipmentId;
	}
	public void setShipmentId(String shipmentId) {
		this.shipmentId = shipmentId;
	}
	public Shipper getFromShipper() {
		return fromShipper;
	}
	public void setFromShipper(Shipper fromShipper) {
		this.fromShipper = fromShipper;
	}
	public Shipper getToShipper() {
		return toShipper;
	}
	public void setToShipper(Shipper toShipper) {
		this.toShipper = toShipper;
	}
	public double getShipmentWeight() {
		return shipmentWeight;
	}
	public void setShipmentWeight(double shipmentWeight) {
		this.shipmentWeight = shipmentWeight;
	}
	public double getShipmentCharge() {
		return shipmentCharge;
	}
	public void setShipmentCharge(double shipmentCharge) {
		this.shipmentCharge = shipmentCharge;
	}
	

}

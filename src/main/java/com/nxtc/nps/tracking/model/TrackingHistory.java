package com.nxtc.nps.tracking.model;

import java.sql.Date;

public class TrackingHistory {
	private String trackingId;
	private String trackMessage;
	private Date trackDate;
	private String shipmentId;
	private String status;
	public String getTrackingId() {
		return trackingId;
	}
	public void setTrackingId(String trackingId) {
		this.trackingId = trackingId;
	}
	public String getTrackMessage() {
		return trackMessage;
	}
	public void setTrackMessage(String trackMessage) {
		this.trackMessage = trackMessage;
	}
	public Date getTrackDate() {
		return trackDate;
	}
	public void setTrackDate(Date trackDate) {
		this.trackDate = trackDate;
	}
	public String getShipmentId() {
		return shipmentId;
	}
	public void setShipmentId(String shipmentId) {
		this.shipmentId = shipmentId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	

}

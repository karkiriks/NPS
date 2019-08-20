package com.nxtc.nps.delivery.service;

import com.nxtc.nps.delivery.model.ProofOfDelivery;

public interface DeliveryService {
	public String insertDeliveryDetail(ProofOfDelivery proofOfDelivery, String shipmentId);
	

}

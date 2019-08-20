package com.nxtc.nps.delivery.dao;

import com.nxtc.nps.delivery.model.ProofOfDelivery;

public interface DeliveryDao {
	public  String insertDeliveryDetail(ProofOfDelivery proofOfDelivery, String shipmentId);

}

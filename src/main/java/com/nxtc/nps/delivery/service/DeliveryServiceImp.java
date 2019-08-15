package com.nxtc.nps.delivery.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nxtc.nps.delivery.dao.DeliveryDao;
import com.nxtc.nps.delivery.model.ProofOfDelivery;

@Service
public class DeliveryServiceImp implements DeliveryService {
	@Autowired
	DeliveryDao deliveryDao;

	@Override
	public String insertDeliveryDetail(ProofOfDelivery proofOfDelivery, String shipmentId) {
		
		return deliveryDao.insertDeliveryDetail(proofOfDelivery, shipmentId);
	}

}

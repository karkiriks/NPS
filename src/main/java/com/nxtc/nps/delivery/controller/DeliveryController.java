package com.nxtc.nps.delivery.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nxtc.nps.delivery.model.ProofOfDelivery;
import com.nxtc.nps.delivery.service.DeliveryService;

@Controller
public class DeliveryController {
	@Autowired
	DeliveryService deliveryService;
	
	
	@RequestMapping(value="/insertDeliveryDetail", method= RequestMethod.POST, consumes="application/json")
	public @ResponseBody String insertDeliveryDetail(HttpServletResponse response, @RequestBody ProofOfDelivery proofOfDelivery, @RequestParam String shipmentId){
		return deliveryService.insertDeliveryDetail(proofOfDelivery, shipmentId);
	}

}

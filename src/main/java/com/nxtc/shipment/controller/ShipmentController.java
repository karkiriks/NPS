package com.nxtc.shipment.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nxtc.shipment.model.Shipment;

@Controller
public class ShipmentController {
	
	@RequestMapping(value="/getShipment", method= RequestMethod.GET, produces="application/json")
	public @ResponseBody  Shipment getShipmentById(HttpServletResponse response, @RequestParam int shipmentId)
	{
		return null;
	}
	
	@RequestMapping(value="/updateShipment", method= RequestMethod.PUT, consumes="application/json")
	public @ResponseBody  String updateShipmentById (HttpServletResponse response, @RequestBody Shipment shipment)
	{
		return null;
	}
	
	@RequestMapping(value="/addShipment", method= RequestMethod.POST, consumes="application/json")
	public @ResponseBody  String addShipment (HttpServletResponse response, @RequestBody Shipment shipment)
	{
		return null;
	}

}

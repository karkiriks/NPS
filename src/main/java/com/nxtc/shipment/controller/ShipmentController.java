package com.nxtc.shipment.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nxtc.shipment.model.Shipment;
import com.nxtc.shipment.services.ShipmentService;

@Controller
public class ShipmentController {
	@Autowired
	ShipmentService shipmentService;
	
	@RequestMapping(value="/getShipment", method= RequestMethod.GET, produces="application/json")
	public @ResponseBody  Shipment getShipmentById(HttpServletResponse response, @RequestParam int shipmentId) throws Exception
	{
		return shipmentService.getShipmentById(shipmentId);
	}
	@RequestMapping(value="/getStatusMessage", method= RequestMethod.GET, produces="application/json")
	public @ResponseBody List<String> getStatusMessage(HttpServletResponse response)
	{
		return shipmentService.getStatusMessage();
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

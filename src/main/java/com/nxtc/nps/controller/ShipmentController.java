package com.nxtc.nps.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller

public class ShipmentController {
	@Autowired
	IShipmentService shipmentService;
	
	@RequestMapping(value="/getShipmentByShipmentId", method= RequestMethod.GET,produces = "application/json")
	public @ResponseBody int getShipmentByShipmentId(HttpServletResponse response, @RequestParam int shipmentId)
	{
		return shipmentService.getShipmentByShipmentId(int shipmentId);
	}
	
	@RequestMapping(value="/getShipmentByShipmentCharge", method= RequestMethod.GET,produces = "application/json")
	public @ResponseBody double getShipmentByShipmentCharge(HttpServletResponse response, @RequestParam double shipmentCharge)
	{
		return shipmentService.getShipmentByShipmentCharge(shipmentCharge);
	}
	
	@RequestMapping(value="/addShipperByfirsName", method = RequestMethod.POST, consumes="application/json")
	public @ResponseBody String addShipperBylastName(HttpServletResponse response,@ RequestBody Shipment shipment)
	{
		return shipmentService.addShipperBylastName(shipment);
	
	}
	
	@RequestMapping(value="/addShipperBylastName", method = RequestMethod.POST, consumes="application/json")
	public @ResponseBody String addShipperBylastName(HttpServletResponse response,@RequestBody Shipment shipment)
	{
		return shipmentService.addShipperBylastName(shipment);
	
	}
	
	@RequestMapping (value="/updateShipmentById", method = RequestMethod.PUT,consumes = "application/json")
	public @ResponseBody  int updateShipmentById(HttpServletResponse response,@RequestBody Shipment shipment)
	{
		return shipmentService.updateShipmentById(shipment);
	}
	
	@RequestMapping (value="/updateShipperByfirstName", method = RequestMethod.PUT,consumes = "application/json")
	public @ResponseBody  int updateShipperByfirstName(HttpServletResponse response,@RequestBody Shipment shipment)
	{
		return shipmentService.updateShipmentByfirstName(shipment);
	}
	
	@RequestMapping (value="/updateShipperBylastName", method = RequestMethod.PUT,consumes = "application/json")
	public @ResponseBody  int updateShipperBylastName(HttpServletResponse response,@RequestBody Shipment shipment)
	{
		return shipmentService.updateShipperBylastName(shipment);
	}
	
	
	@RequestMapping (value="/delByShipmentId", method = RequestMethod.DEL, produces="application/json")
	public @ResponseBody int delByShipmentId(HttpServletResponse response,@RequestParam int shipmentId)
	{
		return shipmentService.delByShipmentId(shipmentId);
	}

}

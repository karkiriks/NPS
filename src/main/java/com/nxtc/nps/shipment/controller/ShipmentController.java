package com.nxtc.nps.shipment.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nxtc.nps.shipment.model.Shipment;
import com.nxtc.nps.shipment.model.Shipper;
import com.nxtc.nps.shipment.services.ShipmentService;
import com.nxtc.nps.tracking.model.TrackingHistory;

@Controller
public class ShipmentController {
	@Autowired
	ShipmentService shipmentService;
	
	@RequestMapping(value="/getShipment", method= RequestMethod.GET, produces="application/json")
	public @ResponseBody  Shipment getShipmentById(HttpServletResponse response, @RequestParam String shipmentId) throws Exception
	{
		System.out.println(shipmentId);
		 Shipment shipment = shipmentService.getShipmentById(shipmentId);
		/* System.out.println(shipment.toString()); */
		 return(shipment);
	}
	@RequestMapping(value="/getStatusMessage", method= RequestMethod.GET, produces="application/json")
	public @ResponseBody List<String> getStatusMessage(HttpServletResponse response)
	{
		return shipmentService.getStatusMessage();
	}
	
	@RequestMapping(value="/updateShipmentStatus", method = RequestMethod.PUT, consumes ="application/json")
	public @ResponseBody String updateShipmentStatus(HttpServletResponse response, @RequestParam String shipmentId, String statusMessage)
	{
		return shipmentService.updateShipmentStatus(shipmentId, statusMessage);
	}
	
	@RequestMapping(value="/updateShipperInfo", method= RequestMethod.PUT, consumes="application/json")
	public @ResponseBody  String updatefromShipperInfo (HttpServletResponse response, @RequestBody Shipper shipper , 
			@RequestParam int shipmentId, @RequestParam String shipperType)
	{
		return shipmentService.updateShipperInfo(shipper, shipmentId, shipperType) ;
	}
	
	@RequestMapping(value="/addShipment", method= RequestMethod.POST, consumes="application/json")
	public @ResponseBody  String addShipment (HttpServletResponse response, @RequestBody Shipment shipment)
	{
		return  shipmentService.addShipment(shipment);
	}
	
	@RequestMapping(value="/updateShipmentById", method = RequestMethod.PUT, consumes="application/json")
	public @ResponseBody String updateShipmentById(HttpServletResponse response, @RequestParam int shipmentId , @RequestBody Shipment shipment)
	{
		return shipmentService.updateShipmentById(shipmentId, shipment);
	}
	

	

}

package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.request.TicketRequest;
import com.example.demo.response.TicketResponse;
import com.example.demo.service.TicketService;

@RestController
public class IrctcRestController {
	
	@Autowired
	private TicketService service;
	
	@PostMapping(
			value ="/bookTicket", 
			consumes={"application/xml", "application/json"})
	public ResponseEntity<String> bookTicket(@RequestBody TicketRequest request){
		String pnr = service.bookTicket(request);
		String msg="Ticket Booking Completed ::" +pnr;
		return new ResponseEntity<>(msg, HttpStatus.CREATED);
		
	}
	@GetMapping(value ="/getTicket/{pnr}", 
			produces= {
					MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<TicketResponse> getTicket(@PathVariable String pnr){
		TicketResponse ticket = service.getTicketByPnr(pnr);
		return new ResponseEntity<>(ticket, HttpStatus.OK);
	}
	@PutMapping(value ="/ticket/update",
			consumes={"application/xml", "application/json"})
	public ResponseEntity<String> updateTicket(@RequestBody TicketResponse response){
	String updateTicket = service.updateTicket(response);
	return new ResponseEntity<>(updateTicket, HttpStatus.OK);
	}
	
	@DeleteMapping("/ticket/{pnr}")
	public ResponseEntity<String> deleteTicket(@PathVariable String pnr){
		String deleteTicket = service.deleteTicket(pnr);
		return new ResponseEntity<>(deleteTicket, HttpStatus.OK);
	
	}
	

}

package com.example.demo.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IrctcDao;
import com.example.demo.request.TicketRequest;
import com.example.demo.response.TicketResponse;

@Service
public class TicketService {
	
	@Autowired
	private IrctcDao dao;
	
	public String bookTicket(TicketRequest request) {
		//logic will be there to book ticket
		
		TicketResponse response = new TicketResponse();
			response.setName(request.getName());
			response.setStatus("CONFIRMED");
			response.setCost("485.00");
			response.setFrom(request.getFrom());
			response.setTo(request.getTo());
			response.setJdate(request.getJdate());
			String pnr = UUID.randomUUID().toString();
			response.setPnr(pnr);
			dao.saveTicket(response);
			return pnr ;
	}
	public TicketResponse getTicketByPnr(String pnr) {
			return dao.getTicketByPnr(pnr);
	}
	public String updateTicket(TicketResponse response) {
		return dao.updateTicket(response);
	}
	public String deleteTicket(String pnr) {
			return dao.deleteTicket(pnr);
	}
}

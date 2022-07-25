package com.example.demo.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.example.demo.response.TicketResponse;

@Repository
public class IrctcDao {
	
	private Map<String, TicketResponse> ticketsMap = new HashMap<>();
	
	public String saveTicket(TicketResponse response) {
		//logic will be there to store ticket information into database table
			 ticketsMap.put(response.getPnr(), response);
			return response.getPnr() ;
	}
	public String updateTicket(TicketResponse response) {
			String pnr = response.getPnr();
			ticketsMap.put(pnr, response);
			return "Ticket updated";
	}
	public String deleteTicket(String pnr) {
			ticketsMap.remove(pnr);
			return "ticket deleted";
			
	}
	
	public TicketResponse getTicketByPnr(String pnr) {
		// this method will get the ticket information from the db table
		if(ticketsMap.containsKey(pnr)) {
				return ticketsMap.get(pnr);
		}else {
				return null;
		}
			
	}
	
	
	

}

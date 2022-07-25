package com.example.demo.response;

import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;

@Data
@XmlRootElement
public class TicketResponse {
	
	private Integer ticketId;
	private String status;
	private String cost;
	private String from;
	private String to;
	private String pnr;
	private String jdate;
	private String name;

}

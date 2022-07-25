package com.example.demo.request;

import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;

@Data
@XmlRootElement
public class TicketRequest {
	
	private String name;
	private String email;
	private Long phno;
	private String from;
	private String to;
	private String jdate;
	private String trainNumber;

}

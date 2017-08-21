package com.movile.movile_java_rest.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Message implements Serializable {

	private static final long serialVersionUID = -1515868877346065095L;
	
	private String destination;
	private String messageText;
	
	public Message(String destination, String messageText) {
		super();
		this.destination = destination;
		this.messageText = messageText;
	}
	
	public String getDestination() {
		return destination;
	}
	
	public void setDestination(String destination) {
		this.destination = destination;
	}
	
	public String getMessageText() {
		return messageText;
	}
	
	public void setMessageText(String messageText) {
		this.messageText = messageText;
	}
}

package com.movile.movile_java_rest;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;


public class MovileConfiguration {

	private final static String URL = "https://api-messaging.movile.com/v1";
	private final String userName;
	private final String authenticationToken;
	
	public MovileConfiguration(String userName, String authenticationToken) {
		super();
		this.userName = userName;
		this.authenticationToken = authenticationToken;
	}
	
	public Client getNewClient() {
		return ClientBuilder.newClient().register(new Authenticator(userName, authenticationToken));
	}

	public Client getNewClientNotAuth() {
		return ClientBuilder.newClient();
	}

	public static String url(String endpoint) {
		return URL + endpoint;
	}
	
	
}

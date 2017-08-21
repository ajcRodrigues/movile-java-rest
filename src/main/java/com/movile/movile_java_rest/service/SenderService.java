package com.movile.movile_java_rest.service;

import java.io.IOException;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.movile.movile_java_rest.MovileConfiguration;
import com.movile.movile_java_rest.model.Message;

public class SenderService {
	
	private final Logger LOG = LoggerFactory.getLogger(getClass());

	private final String SEND_SMS_API = MovileConfiguration.url("/send-sms");	
	private MovileConfiguration movile = null;

	public SenderService(MovileConfiguration movileConfiguration) {
		super();
		this.movile = movileConfiguration;
	}
	
	public String send(Message message) throws IOException {
		LOG.info("Movile-Java Rest: Message {}", message);
		Response response = this.movile.getNewClient().target(SEND_SMS_API).request()
				.post(Entity.entity(message, MediaType.APPLICATION_JSON));

		int responseStatus = response.getStatus();
		String responseText = null;

		if (responseStatus == 200) {
			responseText = response.readEntity(String.class);
			return responseText;
		}
		else {
			// Error Happened
			if (response.hasEntity()) {
				responseText = response.readEntity(String.class);
			}
			response.close();
		}
		throw new IOException("Error on send SMS! Status code: " + responseStatus + " - Response: " + responseText);
	}
}

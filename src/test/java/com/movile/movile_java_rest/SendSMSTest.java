package com.movile.movile_java_rest;

import java.io.IOException;

import org.junit.After;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.movile.movile_java_rest.model.Message;
import com.movile.movile_java_rest.service.SenderService;


public class SendSMSTest {

	
	String USER_NAME = ""; 
	String AUTHENTICATION_TOKEN = "";
	

	@BeforeClass
	public static void beforeClass(){

	}

	@After
	public void tearDown(){

	}


	@Test
	public void sendTest() throws IOException {
		String cellphone = "";
		String messageText = "";
		
		Assert.assertNotNull("Cell phone is invalid", cellphone);
		Assert.assertNotNull("Text of message is invalid", messageText);

		Assert.assertFalse("Cell phone must be a valid string", cellphone.isEmpty());
		Assert.assertFalse("Text of message must be a valid string", messageText.isEmpty());
		

		MovileConfiguration movile = new MovileConfiguration(USER_NAME, AUTHENTICATION_TOKEN);
		SenderService sender = new SenderService(movile);
		String result = sender.send(new Message(cellphone, messageText));
		
		Assert.assertNotNull(result);
	}


}
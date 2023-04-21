package com.pgomezal.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceImpl implements MessageService{

	@Value("${testMessage.message:${testMessage.default-message}}")
	private String message;
	
	@Override
	public String getMessage() {
		
		return message;
	}

	
}

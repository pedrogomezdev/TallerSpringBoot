package com.pgomezal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pgomezal.service.MessageServiceImpl;

@RestController
@RequestMapping(value="/api/v1")
public class MessageController {

	@Autowired
	MessageServiceImpl messageServiceImpl;
	
	@GetMapping(value="/message")
	public String getMessage() {
		return messageServiceImpl.getMessage();
	}
}

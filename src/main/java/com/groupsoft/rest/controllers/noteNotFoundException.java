package com.groupsoft.rest.controllers;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class noteNotFoundException extends RuntimeException {

	public noteNotFoundException(String message) {
		super(message);
	}
}

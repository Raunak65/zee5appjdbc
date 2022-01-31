package com.zee.zee5app.exception;

import lombok.ToString;

@ToString
public class InvalidPasswordException extends Exception {

	public InvalidPasswordException(String msg) {
		// TODO Auto-generated constructor stub
		System.out.println(msg);
	}
}

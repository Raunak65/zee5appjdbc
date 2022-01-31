package com.zee.zee5app.exception;

import lombok.ToString;
@ToString(callSuper = true)
public class IdInvalidLengthException extends Exception {

	public IdInvalidLengthException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	//	same as lombok ToString
	//	@Override
	//	public String toString() {
	//		return "IdNotFoundException [toString()=" + super.toString() + "]";
	//	}
	

}

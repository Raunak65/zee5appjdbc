package com.zee.zee5app.dto;

import lombok.Data;

@Data
public class Login {

	private String username;
	private String password;
	private String regid;
	private ROLE role;
}

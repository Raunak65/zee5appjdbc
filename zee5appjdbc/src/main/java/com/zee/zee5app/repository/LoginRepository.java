package com.zee.zee5app.repository;

import java.sql.SQLException;

import com.zee.zee5app.dto.Login;
import com.zee.zee5app.dto.ROLE;

public interface LoginRepository {
	public String addCredentials(Login login) throws SQLException;
	public String deleteCredentials(String username);
	public String changePassword(String username,String password);
	public String changeRole(String username,ROLE role);
}

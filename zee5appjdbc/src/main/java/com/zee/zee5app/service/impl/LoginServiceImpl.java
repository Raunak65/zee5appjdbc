package com.zee.zee5app.service.impl;

import java.io.IOException;
import java.sql.SQLException;

import org.springframework.stereotype.Service;

import com.zee.zee5app.dto.Login;
import com.zee.zee5app.dto.ROLE;
import com.zee.zee5app.repository.LoginRepository;
import com.zee.zee5app.repository.UserRepository2;
import com.zee.zee5app.repository.impl.LoginRepositoryImpl;
import com.zee.zee5app.repository.impl.UserRepositoryImpl;
import com.zee.zee5app.service.LoginService;
import com.zee.zee5app.service.UserService2;
@Service
public class LoginServiceImpl implements LoginService {

	private LoginRepository repository ;
	private static LoginService loginservice;

	@Override
	public String addCredentials(Login login) throws SQLException {
		// TODO Auto-generated method stub
		return this.repository.addCredentials(login);
	}

	@Override
	public String deleteCredentials(String username) {
		// TODO Auto-generated method stub
		return this.repository.deleteCredentials(username);
	}

	@Override
	public String changePassword(String username, String password) {
		// TODO Auto-generated method stub
		return this.repository.changePassword(username,password);
	}

	@Override
	public String changeRole(String username, ROLE role) {
		// TODO Auto-generated method stub
		return this.repository.changeRole(username, role);
	}
}

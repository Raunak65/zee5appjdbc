package com.zee.zee5app.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.naming.InvalidNameException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.zee.zee5app.dto.Register;
import com.zee.zee5app.exception.IdInvalidLengthException;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidEmailException;
import com.zee.zee5app.exception.InvalidPasswordException;
import com.zee.zee5app.repository.UserRepository2;
import com.zee.zee5app.repository.impl.UserRepositoryImpl;
import com.zee.zee5app.service.UserService2;

@Service
public class UserServiceImpl implements UserService2 {
	@Autowired
	private UserRepository2 repository ;


	@Override
	public String addUser(Register register) {
		// TODO Auto-generated method stub
		return this.repository.addUser(register);
	}

	@Override
	public String updateUser(String id, Register register) {
		// TODO Auto-generated method stub
		return this.repository.updateUser(id, register);
	}

	@Override
	public Optional<Register> getUserById(String id) 
			throws IdNotFoundException, 
			InvalidNameException, 
			InvalidPasswordException, 
			InvalidEmailException, 
			IdInvalidLengthException {
		// TODO Auto-generated method stub
		return this.repository.getUserById(id);
	}

	@Override
	public List<Register> getAllUsers() throws InvalidNameException, IdNotFoundException, InvalidPasswordException, InvalidEmailException, IdInvalidLengthException {
		// TODO Auto-generated method stub
		return this.repository.getAllUsers();
	}

	@Override
	public String deleteUserById(String id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		return this.repository.deleteUserById(id);
	}
	@Override
	public Optional<List<Register>> getAllUsersDetails() throws InvalidNameException, IdNotFoundException, InvalidPasswordException, InvalidEmailException, IdInvalidLengthException {
		// TODO Auto-generated method stub
		return this.repository.getAllUsersDetails();

	}
}

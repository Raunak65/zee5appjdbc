package com.zee.zee5app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.naming.InvalidNameException;

import com.zee.zee5app.dto.Register;
import com.zee.zee5app.exception.IdInvalidLengthException;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidEmailException;
import com.zee.zee5app.exception.InvalidPasswordException;

public interface UserService2 {

	public String addUser(Register register);
	public String updateUser(String id, Register register);
	public Optional<Register> getUserById(String id) 
			throws IdNotFoundException, 
			InvalidNameException, 
			InvalidPasswordException, 
			InvalidEmailException, 
			IdInvalidLengthException;
	public List<Register> getAllUsers() 
			throws InvalidNameException, 
			IdNotFoundException, 
			InvalidPasswordException, 
			InvalidEmailException, 
			IdInvalidLengthException;
	public String deleteUserById(String id) throws IdNotFoundException;
	public Optional<List<Register>> getAllUsersDetails() throws InvalidNameException, IdNotFoundException, InvalidPasswordException, InvalidEmailException, IdInvalidLengthException;
}

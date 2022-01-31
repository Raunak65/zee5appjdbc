package com.zee.zee5app.service;

import com.zee.zee5app.dto.Register;
import com.zee.zee5app.repository.UserRepository;

public class UserService {
//	Instances
	
	private UserRepository repository = UserRepository.getInstance();
	private UserService() {
		
	}
//	If we want to create a single object then we have to create 
//	it inside the same class
//	and we have to share ref with others
//	to do the same we have to declare a method
	private static UserService service = null;
//	This should be static 
//	Only one copy
	
	public static UserService getInstance() {
//		This becomes a object independent
//		static will make it independent of the object
		if (service == null) service = new UserService();
		return service;
	}
	public String addUser(Register register) {
		return this.repository.addUser(register);
	}
	public Register getUserById(String id) {
		return this.repository.getUserById(id);
	}
	public Register[] getUsers() {
		return this.repository.getUsers();
	}
	public String deleteUser(String id) {
		return this.repository.deleteUser(id);
	}
}
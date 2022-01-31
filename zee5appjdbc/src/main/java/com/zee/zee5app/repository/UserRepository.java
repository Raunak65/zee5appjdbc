package com.zee.zee5app.repository;

import javax.naming.InvalidNameException;

import com.zee.zee5app.dto.Register;
import com.zee.zee5app.exception.IdInvalidLengthException;
import com.zee.zee5app.exception.InvalidEmailException;
import com.zee.zee5app.exception.InvalidPasswordException;

public class UserRepository {
	
	private Register[] registers = new Register[10];
	private UserRepository() {
		
	}
//	delete an user by id
	public String deleteUser(String id) {
		Register temp[] = new Register[registers.length];
		int i = 0;
		int j = 0;
		for (Register currRegister : registers) {
			if (currRegister!=null) {
				if (currRegister.getId().equals(id)) {
					j++;
				}
				else {
					temp[i] = registers[j];
					i++;
					j++;
				}
			}	
		}
		registers = temp;
		return "success";
		
		
	}
	
//	update an user
	public String updateUser(String id,Register register) {
		for (Register currRegister : registers) {
			if (currRegister!=null) {
				if (currRegister.getId().equals(id)) {
					try {
						currRegister.setEmail(register.getEmail());
					} catch (InvalidEmailException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					try {
						currRegister.setFirstName(register.getFirstName());
					} catch (InvalidNameException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					try {
						currRegister.setLastName(register.getLastName());
					} catch (InvalidNameException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					try {
						currRegister.setPassword(register.getPassword());
					} catch (InvalidPasswordException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					return "updated";
				}
			}	
		}
		return null;
	}
	
//	get users
	public Register[] getUsers() {
		return registers;
	}
	
//	get user by Id
	public Register getUserById(String id) {
		
		
		for (Register register : registers) {
			if(register!=null) {
				
				if(register.getId().equals(id)) {
					return register;
				}
			}
		}
		return null;
	}
	
//	add user
	private static int count = -1;
	public String addUser(Register register) {
		if(count == registers.length-1) {
			Register temp[] = new Register[2*registers.length];
			System.arraycopy(registers, 0, temp,0, registers.length);
			registers = temp;
			registers[++count] = register;
			return "Successfully added User";
		}
		registers[++count] = register;
		return "Successfully added User";
	}
	private static UserRepository userrepository ;
	public static UserRepository getInstance() {
		if (userrepository == null) userrepository = new UserRepository();
		return userrepository;
	}
}

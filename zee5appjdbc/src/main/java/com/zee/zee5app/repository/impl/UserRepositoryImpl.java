package com.zee.zee5app.repository.impl;

import java.io.IOException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.naming.InvalidNameException;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.zee.zee5app.dto.Login;
import com.zee.zee5app.dto.ROLE;
import com.zee.zee5app.dto.Register;
import com.zee.zee5app.exception.IdInvalidLengthException;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidEmailException;
import com.zee.zee5app.exception.InvalidPasswordException;
import com.zee.zee5app.repository.LoginRepository;
import com.zee.zee5app.repository.UserRepository2;
import com.zee.zee5app.utils.DBUtils;
import com.zee.zee5app.utils.PasswordUtils;
@Repository
public class UserRepositoryImpl implements UserRepository2 {
	
	@Autowired // it will bring ur already created object either by using name / type
	DataSource dataSource;
	@Autowired
	LoginRepository loginRepository;

	public UserRepositoryImpl() throws IOException {
		loginRepository = LoginRepositoryImpl.getInstance();
		//dbutils = DBUtils.getInstance();
	}
	
	
	

	@Override
	public String addUser(Register register) {
		// TODO Auto-generated method stub
		Connection connection=null;
		try {
			connection = dataSource.getConnection();
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		PreparedStatement preparedStatement = null;
		
		String insertStatement = 
				"insert into register"
				+ " (regid,firstname,lastname,email,contactnumber,password)"
				+ " values(?,?,?,?,?,?)";
		
		try {
			preparedStatement = connection.prepareStatement(insertStatement);
			preparedStatement.setString(1, register.getId());
			preparedStatement.setString(2, register.getFirstName());
			preparedStatement.setString(3, register.getLastName());
			preparedStatement.setString(4, register.getEmail());
			preparedStatement.setBigDecimal(5, register.getContactnumber());
			String salt = PasswordUtils.getSalt(30);
			String encryptedPassword = PasswordUtils.generateSecurePassword(register.getPassword(),salt);
			preparedStatement.setString(6, encryptedPassword);
			
			
//			At the same time username,password, regid we have to store
//			in the login table as well. Since these are required fields
//			for login.
			
			
			
//			returns number of rows affected by DML statement.
			int result = preparedStatement.executeUpdate();
			if(result>0) {
//				connection.commit();
				Login login = new Login();
				login.setUsername(register.getEmail());
				login.setPassword(encryptedPassword);
				login.setRegid(register.getId());
				login.setRole(ROLE.ROLE_USER);
				String res = loginRepository.addCredentials(login);
				if(res.equals("Success")) {
					return "Success";
				}
				else {
					connection.rollback();
					return "Failed";
				}
				
			}
			else {
				connection.rollback();
				return "failed";
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			return "Failed";
		}
	}
	
	@Override
	public Optional<Register> getUserById(String id) 
			throws IdNotFoundException, 
			InvalidPasswordException, 
			InvalidEmailException, 
			InvalidNameException, 
			IdInvalidLengthException {
		// TODO Auto-generated method stub
		Connection connection=null;
		try {
			connection = dataSource.getConnection();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		PreparedStatement preparedStatement = null;

//		Result set is java.sql object that stores the result from select statement. 
		ResultSet resultSet = null;
		
		String selectStatement = 
				"select * from register where regid=?";
		
		
		try {
			preparedStatement = connection.prepareStatement(selectStatement);
			preparedStatement.setString(1, id);
			
//			Returns the result set object.
			resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {
//				next() method is used to traverse the result set.
//				Initially result set will be placed at 1st record.
//				when we will call 1st time it will retrieve the 1st record
//				and refer to the 2nd record
				Register register = new Register();
				register.setId(resultSet.getString("regid"));
				register.setFirstName(resultSet.getString("firstname"));
				register.setLastName(resultSet.getString("lastname"));
				register.setEmail(resultSet.getString("email"));
				register.setPassword(resultSet.getString("password"));
				register.setContactnumber(resultSet.getBigDecimal("contactnumber"));
				return Optional.of(register);
		}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Optional.empty();
	}

	@Override
	public String updateUser(String id, Register register) {
		// TODO Auto-generated method stub
		Connection connection=null;
		try {
			connection = dataSource.getConnection();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		PreparedStatement preparedStatement = null;
		
		String updateStatement = 
				"update register set firstname=?,lastname=?,"
				+ "email=?,contactnumber=?,password=? where regid=?";
		
		try {
			preparedStatement = connection.prepareStatement(updateStatement);
			preparedStatement.setString(1, register.getFirstName());
			preparedStatement.setString(2, register.getLastName());
			preparedStatement.setString(3, register.getEmail());
			preparedStatement.setBigDecimal(4, register.getContactnumber());
			preparedStatement.setString(6, register.getId());
			String salt = PasswordUtils.getSalt(30);
			String encryptedPassword = PasswordUtils.generateSecurePassword(register.getPassword(),salt);
			preparedStatement.setString(5, encryptedPassword);
			
			
//			At the same time username,password, regid we have to store
//			in the login table as well. Since these are required fields
//			for login.
//=========================================================================
//			Pending================================================Pending
//			Pending================================================Pending
//			Pending==UPDATE LOGIN CREDENTIALS WHILE UPDATING USER==Pending
//			Pending================================================Pending
//			Pending================================================Pending
//=========================================================================		
//			returns number of rows affected by DML statement.
			int result = preparedStatement.executeUpdate();
			if(result>0) {
				Login login = new Login();
				login.setUsername(register.getEmail());
				login.setPassword(encryptedPassword);
				login.setRegid(register.getId());
				login.setRole(ROLE.ROLE_USER);
				String res = loginRepository.changePassword(login.getUsername(),encryptedPassword);
				if(res.equals("Success")) {
					return "Success";
				}
				else {
					connection.rollback();
					return "Failed";
				}
				
			}
			else {
				connection.rollback();
				return "failed";
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			return "Failed";
		}
		
	}

	@Override
	public Optional<List<Register>> getAllUsersDetails()
			throws IdNotFoundException, 
			InvalidPasswordException, 
			InvalidEmailException, 
			InvalidNameException, 
			IdInvalidLengthException
	{
		List<Register> registers = new ArrayList<Register>();
		Connection connection=null;
		try {
			connection = dataSource.getConnection();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		PreparedStatement preparedStatement = null;

//		Result set is java.sql object that stores the result from select statement. 
		ResultSet resultSet = null;
		
		String selectStatement = 
				"select * from register";
		
		
		try {
			preparedStatement = connection.prepareStatement(selectStatement);
			
//			Returns the result set object.
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
//				next() method is used to traverse the result set.
//				Initially result set will be placed at 1st record.
//				when we will call 1st time it will retrieve the 1st record
//				and refer to the 2nd record
				Register register = new Register();
				register.setId(resultSet.getString("regid"));
				register.setFirstName(resultSet.getString("firstname"));
				register.setLastName(resultSet.getString("lastname"));
				register.setEmail(resultSet.getString("email"));
				register.setPassword(resultSet.getString("password"));
				register.setContactnumber(resultSet.getBigDecimal("contactnumber"));
				registers.add(register);
		}
			return Optional.ofNullable(registers);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Optional.empty();
	}

	@Override
	public List<Register> getAllUsers() throws InvalidNameException, IdNotFoundException, InvalidPasswordException, InvalidEmailException, IdInvalidLengthException {
		Optional<List<Register>> optional = getAllUsersDetails();
		if(optional.isEmpty()) {
			return null;
		}
		else {
			List<Register> list = optional.get();
			return list;
		}
	}

	@Override
	public String deleteUserById(String id) throws IdNotFoundException {
		Connection connection=null;
		try {
			connection = dataSource.getConnection();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		PreparedStatement preparedStatement = null;
		
		String deleteStatement = 
				"delete from register where regid=?";
		
		try {
			preparedStatement = connection.prepareStatement(deleteStatement);
			preparedStatement.setString(1, id);
//			returns number of row affected by DML statement.
			int result = preparedStatement.executeUpdate();
			if(result>0) {
				String res = loginRepository.deleteCredentials(id);
				if(res.equals("Success")) {
					return "Success";
				}
				else {
					connection.rollback();
					return "Failed";
				}
			}
			else {
				return "failed";
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "failed";
		}
	}
}

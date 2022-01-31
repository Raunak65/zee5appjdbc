package com.zee.zee5app.repository.impl;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zee.zee5app.dto.Login;
import com.zee.zee5app.dto.ROLE;
import com.zee.zee5app.repository.LoginRepository;
import com.zee.zee5app.repository.MoviesRepository2;
import com.zee.zee5app.utils.DBUtils;
import com.zee.zee5app.utils.PasswordUtils;
@Repository
public class LoginRepositoryImpl implements LoginRepository {

	private static DBUtils dbUtils = null;
	@Autowired // it will bring ur already created object either by using name / type
	DataSource dataSource;
	
	private static LoginRepository repository = null;
	public static LoginRepository getInstance() {
		if(repository == null){
			repository = new LoginRepositoryImpl();
		}
		return repository;
	}
	

	
	@Override
	public String addCredentials(Login login)  {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		String insertStatement = 
				"insert into login"
				+ " (username,password,regid,role)"
				+ " values(?,?,?,?)";
		try {
			connection = dataSource.getConnection();
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		try {
			preparedStatement = connection.prepareStatement(insertStatement);
			preparedStatement.setString(1, login.getUsername());
			preparedStatement.setString(2, login.getPassword());
			preparedStatement.setString(3, login.getRegid());
			preparedStatement.setString(4, login.getRole().toString());
			int result = preparedStatement.executeUpdate();
			if (result>0) {
//				connection.commit();
				return "Success";
			}
			else {
				connection.rollback();
				return "Failed";
			}
			
		} catch (SQLException e) {
//			 TODO Auto-generated catch block
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			e.printStackTrace();
		}
		return "Failed";
	}

	@Override
	public String deleteCredentials(String username) {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		String insertStatement = 
				"delete from login where username=?";
		try {
			connection = dataSource.getConnection();
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		try {
			preparedStatement = connection.prepareStatement(insertStatement);
			preparedStatement.setString(1, username);
			int result = preparedStatement.executeUpdate();
			if (result>0) {
				connection.commit();
				return "Success";
			}
			else {
				connection.rollback();
				return "Failed";
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		return "Failed";
	}

	@Override
	public String changePassword(String username, String password) {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		String updateStatement = 
				"update login set password=? where username=?";
		try {
			connection = dataSource.getConnection();
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		try {
			preparedStatement = connection.prepareStatement(updateStatement);
			preparedStatement.setString(2, username);
			preparedStatement.setString(1, password);
			int result = preparedStatement.executeUpdate();
			if (result>0) {
				connection.commit();
				return "Success";
			}
			else {
				connection.rollback();
				return "Failed";
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		return "Failed";
	}

	@Override
	public String changeRole(String username, ROLE role) {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = dataSource.getConnection();
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		String updateStatement = "update login set role=? where username=?";
		try {
			preparedStatement = connection.prepareStatement(updateStatement);
			preparedStatement.setString(1, role.toString());
			preparedStatement.setString(2, username);
			int result = preparedStatement.executeUpdate();
			if (result>0) {
				connection.commit();
				return "Success";
			}
			else {
				connection.rollback();
				return "Failed";
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		return "Failed";
		
	}

}

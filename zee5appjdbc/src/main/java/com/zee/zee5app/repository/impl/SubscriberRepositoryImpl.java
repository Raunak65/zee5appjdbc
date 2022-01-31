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

import org.springframework.stereotype.Repository;

import com.zee.zee5app.dto.Movies;
import com.zee.zee5app.dto.Register;
import com.zee.zee5app.dto.Series;
import com.zee.zee5app.dto.Subscription;
import com.zee.zee5app.exception.IdInvalidLengthException;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidAmountException;
import com.zee.zee5app.dto.Subscription;
import com.zee.zee5app.repository.LoginRepository;
import com.zee.zee5app.repository.SubscriberRepository2;
import com.zee.zee5app.repository.UserRepository2;
import com.zee.zee5app.utils.DBUtils;

import lombok.AccessLevel;
import lombok.Setter;
@Repository
public class SubscriberRepositoryImpl implements SubscriberRepository2 {
	
	private static DBUtils dbUtils = null;
	private static SubscriberRepository2 subscriberrepository = null;
	
	
	private List<Subscription> subscribers = new ArrayList<Subscription>();


	
	@Override
	public String addSubscriber(Subscription subscriber) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String insertStatement = "insert into subscription"
				+ " (regid,subscriptionId,dateOfPurchase,dateOfExpiry,amount,paymentMode,status,type,autorenewal)"
				+ " values(?,?,?,?,?,?,?,?,?)";
		connection = dbUtils.getConnection();

		try {
			preparedStatement = connection.prepareStatement(insertStatement);
			preparedStatement.setString(1, subscriber.getRegid());
			preparedStatement.setString(2, subscriber.getId());
			preparedStatement.setString(3, subscriber.getDateOfPurchase());
			preparedStatement.setString(4, subscriber.getExpiryDate());
			preparedStatement.setFloat(5, subscriber.getAmount());
			preparedStatement.setString(6, subscriber.getPaymentMode());
			preparedStatement.setString(7, subscriber.getStatus());
			preparedStatement.setString(8, subscriber.getType());
			preparedStatement.setString(9, subscriber.getAutoRenewal());

//					returns number of rows affected by DML statement.
			int result = preparedStatement.executeUpdate();
			if (result > 0) {
				connection.commit();
				return "Success";
			} else {
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
		} finally {
			dbUtils.closeConnection(connection);
		}
	}

	@Override
	public String updateSubscriber(String id, Subscription subscriber)
			throws IdInvalidLengthException, InvalidAmountException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String insertStatement = "update subscription set "
				+ "regid=?,dateOfPurchase=?,dateOfExpiry=?,"
				+ "amount=?,paymentMode=?,status=?,type=?,autorenewal=? "
				+ "where subscriptionId=?";
		connection = dbUtils.getConnection();

		try {
			preparedStatement = connection.prepareStatement(insertStatement);
			preparedStatement.setString(1, subscriber.getRegid());
			preparedStatement.setString(2, subscriber.getDateOfPurchase());
			preparedStatement.setString(3, subscriber.getExpiryDate());
			preparedStatement.setFloat(4, subscriber.getAmount());
			preparedStatement.setString(5, subscriber.getPaymentMode());
			preparedStatement.setString(6, subscriber.getStatus());
			preparedStatement.setString(7, subscriber.getType());
			preparedStatement.setString(8, subscriber.getAutoRenewal());
			preparedStatement.setString(9, subscriber.getId());

//			returns number of rows affected by DML statement.
			int result = preparedStatement.executeUpdate();
			if (result > 0) {
				connection.commit();
				return "Success";
			} else {
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
		} finally {
			dbUtils.closeConnection(connection);
		}
	}

	@Override
	public Optional<Subscription> getSubscriberById(String id) throws IdNotFoundException, InvalidAmountException, IdInvalidLengthException {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement preparedStatement = null;

//		Result set is java.sql object that stores the result from select statement. 
		ResultSet resultSet = null;

		String selectStatement = "select * from subscription where subscriptionId=?";

		connection = dbUtils.getConnection();

		try {
			preparedStatement = connection.prepareStatement(selectStatement);
			preparedStatement.setString(1, id);

//			Returns the result set object.
			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
//				next() method is used to traverse the result set.
//				Initially result set will be placed at 1st record.
//				when we will call 1st time it will retrieve the 1st record
//				and refer to the 2nd record
				Subscription subscriber = new Subscription();
				subscriber.setId(resultSet.getString("subscriptionId"));
				subscriber.setRegid(resultSet.getString("regid"));
				subscriber.setDateOfPurchase(resultSet.getString("dateOfPurchase"));
				subscriber.setExpiryDate(resultSet.getString("dateOfExpiry"));
				subscriber.setAmount(resultSet.getFloat("amount"));
				subscriber.setPaymentMode(resultSet.getString("paymentMode"));
				subscriber.setStatus(resultSet.getString("status"));
				subscriber.setType(resultSet.getString("type"));
				subscriber.setAutoRenewal(resultSet.getString("autoRenewal"));
				return Optional.of(subscriber);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			dbUtils.closeConnection(connection);
		}
		return Optional.empty();
	}

	@Override
	public List<Subscription> getAllSubscribers() throws  IdInvalidLengthException, InvalidAmountException, InvalidNameException {
		Optional<List<Subscription>> optional = getAllSubscriptionsDetails();
		if(optional.isEmpty()) {
			return null;
		}
		else {
			List<Subscription> list = optional.get();
			return list;
		}
	}

	@Override
	public String deleteSubscriberById(String id) throws IdNotFoundException, InvalidAmountException, IdInvalidLengthException {
		Optional<Subscription> optional = this.getSubscriberById(id);
		if (optional.isPresent()) {
			boolean result = subscribers.remove(optional.get());
			if (result) {
				return "Success";
			}
			return "failed";
		}
		return "failed";
	}

	@Override
	public Optional<List<Subscription>> getAllSubscriptionsDetails()
			throws IdInvalidLengthException, InvalidNameException, InvalidAmountException {
		List<Subscription> subscribers = new ArrayList<Subscription>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;

//		Result set is java.sql object that stores the result from select statement. 
		ResultSet resultSet = null;

		String selectStatement = "select * from subscription";

		connection = dbUtils.getConnection();

		try {
			preparedStatement = connection.prepareStatement(selectStatement);

//			Returns the result set object.
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
//				next() method is used to traverse the result set.
//				Initially result set will be placed at 1st record.
//				when we will call 1st time it will retrieve the 1st record
//				and refer to the 2nd record
				Subscription subscriber = new Subscription();
				subscriber.setId(resultSet.getString("subscriptionId"));
				subscriber.setRegid(resultSet.getString("regid"));
				subscriber.setDateOfPurchase(resultSet.getString("dateOfPurchase"));
				subscriber.setExpiryDate(resultSet.getString("dateOfExpiry"));
				subscriber.setAmount(resultSet.getFloat("amount"));
				subscriber.setPaymentMode(resultSet.getString("paymentMode"));
				subscriber.setStatus(resultSet.getString("status"));
				subscriber.setType(resultSet.getString("type"));
				subscriber.setAutoRenewal(resultSet.getString("autoRenewal"));
				subscribers.add(subscriber);
			}
			return Optional.ofNullable(subscribers);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			dbUtils.closeConnection(connection);
		}
		return Optional.empty();
	}

}

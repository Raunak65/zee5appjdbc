package com.zee.zee5app.service.impl;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.naming.InvalidNameException;

import org.springframework.stereotype.Service;

import com.zee.zee5app.dto.Subscription;
import com.zee.zee5app.exception.IdInvalidLengthException;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidAmountException;
import com.zee.zee5app.exception.InvalidEmailException;
import com.zee.zee5app.exception.InvalidPasswordException;
import com.zee.zee5app.repository.SubscriberRepository2;
import com.zee.zee5app.repository.UserRepository2;
import com.zee.zee5app.repository.impl.SubscriberRepositoryImpl;
import com.zee.zee5app.service.SubscriberService2;
import com.zee.zee5app.service.UserService2;
@Service
public class SubscriberServiceImpl implements SubscriberService2 {

	private SubscriberRepository2 repository ;
	private static SubscriberService2 subscribererservice;
	
	@Override
	public String addSubscriber(Subscription subscriber) {
		return this.repository.addSubscriber(subscriber);
	}

	@Override
	public String updateSubscriber(String id,Subscription subscriber) throws IdInvalidLengthException, InvalidAmountException {
		return this.repository.updateSubscriber(id,subscriber);
	}

	@Override
	public Optional<Subscription> getSubscriberById(String id) throws IdNotFoundException, InvalidAmountException, IdInvalidLengthException {
		return this.repository.getSubscriberById(id);
	}

	@Override
	public List<Subscription> getAllSubscribers() throws InvalidNameException, IdInvalidLengthException, InvalidAmountException {
		return this.repository.getAllSubscribers();
	}
	@Override
	public String deleteSubscriberById(String id) throws IdNotFoundException, InvalidAmountException, IdInvalidLengthException {
		return this.repository.deleteSubscriberById(id);
	}

	@Override
	public Optional<List<Subscription>> getAllSubscriptionssDetails() throws InvalidNameException, IdNotFoundException,
			InvalidPasswordException, InvalidEmailException, IdInvalidLengthException, InvalidAmountException {
		// TODO Auto-generated method stub
		return this.repository.getAllSubscriptionsDetails();
	}

}

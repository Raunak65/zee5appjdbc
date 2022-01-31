package com.zee.zee5app.repository;

import java.util.List;
import java.util.Optional;

import javax.naming.InvalidNameException;

import com.zee.zee5app.dto.Movies;
import com.zee.zee5app.dto.Series;
import com.zee.zee5app.dto.Subscription;
import com.zee.zee5app.exception.IdInvalidLengthException;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidAmountException;

public interface SubscriberRepository2 {
	public String addSubscriber(Subscription subscriber);
	public String updateSubscriber(String id, Subscription subscriber) throws IdInvalidLengthException, InvalidAmountException;
	public Optional<Subscription> getSubscriberById(String id) throws IdNotFoundException, InvalidAmountException, IdInvalidLengthException;
	public List<Subscription> getAllSubscribers() throws InvalidNameException, IdInvalidLengthException, InvalidAmountException;
	public String deleteSubscriberById(String id) throws IdNotFoundException, InvalidAmountException, IdInvalidLengthException;
	public Optional<List<Subscription>> getAllSubscriptionsDetails() throws IdInvalidLengthException, InvalidNameException, InvalidAmountException;

}

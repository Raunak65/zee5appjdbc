package com.zee.zee5app.repository;

import com.zee.zee5app.dto.Subscription;
import com.zee.zee5app.exception.IdInvalidLengthException;

public class SubscriberRepository {
	
	private Subscription[] subscribers = new Subscription[10];
	private SubscriberRepository() {
		
	}
//	delete an user by id
	public String deleteSubscriber(String id) {
		Subscription temp[] = new Subscription[subscribers.length];
		int i = 0;
		int j = 0;
		for (Subscription currSubscriber : subscribers) {
			if (currSubscriber!=null) {
				if (currSubscriber.getId().equals(id)) {
					j++;
				}
				else {
					temp[i] = subscribers[j];
					i++;
					j++;
				}
			}	
		}
		subscribers = temp;
		return "success";
	}

//	update an user
	public String updateSubscriber(String id,Subscription subscriber) throws IdInvalidLengthException {
		for (Subscription currSubscriber : subscribers) {
			if (currSubscriber!=null) {
				if (currSubscriber.getId().equals(id)) {
					currSubscriber.setAutoRenewal(subscriber.getAutoRenewal());
					currSubscriber.setDateOfPurchase(subscriber.getDateOfPurchase());
					currSubscriber.setExpiryDate(subscriber.getExpiryDate());
					currSubscriber.setType(subscriber.getType());
					currSubscriber.setId(subscriber.getId());
					currSubscriber.setStatus(subscriber.getStatus());
					return "updated";
				}
			}	
		}
		return null;
	}
	
//	get users
	public Subscription[] getSubscribers() {
		return subscribers;
	}
	
//	get user by Id
	public Subscription getSubscriberById(String id) {
		for (Subscription subscriber : subscribers) {
			if(subscriber!=null) {
				if(subscriber.getId().equals(id)) {
					return subscriber;
				}
			}
		}
		return null;
	}
	
//	add user
	private static int count = -1;
	public String addSubscriber(Subscription subscriber) {
		if(count == subscribers.length-1) {
			Subscription temp[] = new Subscription[2*subscribers.length];
			System.arraycopy(subscribers, 0, temp,0, subscribers.length);
			subscribers = temp;
			subscribers[++count] = subscriber;
			return "Successfully added User";
		}
		subscribers[++count] = subscriber;
		return "Successfully added subscriber";
	}
	private static SubscriberRepository subscriberRepository ;
	public static SubscriberRepository getInstance() {
		if (subscriberRepository == null) subscriberRepository = new SubscriberRepository();
		return subscriberRepository;
	}
}


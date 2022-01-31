package com.zee.zee5app.service;

import com.zee.zee5app.dto.Subscription;
import com.zee.zee5app.exception.IdInvalidLengthException;
import com.zee.zee5app.repository.SubscriberRepository;

public class SubscriberService {
//	Instances
	private SubscriberRepository repository = SubscriberRepository.getInstance();
	private SubscriberService() {
		
	}
//	If we want to create a single object then we have to create 
//	it inside the same class
//	and we have to share ref with others
//	to do the same we have to declare a method
	private static SubscriberService service = null;
//	This should be static 
//	Only one copy
	
	public static SubscriberService getInstance() {
//		This becomes a object independent
//		static will make it independent of the object
		if (service == null) service = new SubscriberService();
		return service;
	}
	public String addSubscriber(Subscription subscriber) {
		return this.repository.addSubscriber(subscriber);
	}
	public Subscription getSubscriberById(String id) {
		return this.repository.getSubscriberById(id);
	}
	public Subscription[] getSubscribers() {
		return this.repository.getSubscribers();
	}
	public String deleteSubscriber(String id) {
		return this.repository.deleteSubscriber(id);
	}
	public String updateSubscriber(String id,Subscription subscriber) throws IdInvalidLengthException {
		return this.repository.updateSubscriber(id,subscriber);
	}
}
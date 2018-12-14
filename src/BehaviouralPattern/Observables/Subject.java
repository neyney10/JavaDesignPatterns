package behaviouralPattern.observables;

import java.util.HashSet;
import java.util.Set;

/**
 * Hot Subject. <br>
 * Subject is a basic type of Observable that notify about events to all observers that it contains. <br>
 * observers can subscribe to the subject's event notifications and unsubscribe to them. <br>
 * every observer that subscribed to it will receive the event's data by subject is calling to it's "update(data)" function. <br>
 * it called "Hot" because it is emits events when it receives them.
 * @author Neyney
 * @param <T>
 */
public class Subject<T> implements Observable<T> {

	/*
	 * a data structure that contains all observers to notify when event occurs. can be any data structure.
	 */
	Set<Observer<T>> observers;
	
	/**
	 * [Constructor] <br>
	 * Creates a new "Subject" object, initializing the data structure that will contain observers.
	 */
	public Subject() {
		this.observers = new HashSet<Observer<T>>();
	}
	
	/**
	 * subscribing an observer to this observable, when subscribed, the observer will get notified about events.
	 * @param o - Observer - an observer to add.
	 */
	@Override
	public void subscribe(Observer<T> o) {
		observers.add(o);
	}

	/**
	 * unsubscribing an observer to this observable, when unsubscribed, the observer will not get any notifications about events 
	 * from this observable any longer.
	 * @param o - Observer - an observer to remove/unsubscribe.
	 */
	@Override
	public void unsubscribe(Observer<T> o) {
		observers.remove(o);
	}

	/**
	 * report/notify about an event to all observers, passing along the event's data.
	 * @param data - the event's data.
	 */
	@Override
	public void emitEvent(T data) {
		for(Observer<T> o : observers)
			o.onEvent(data);
	}


}

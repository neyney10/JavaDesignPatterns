package behaviouralPattern.observables;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

/**
 * a cold subject is a lazy subject, it will not emit events when there are no observers subscribed to it, 
 * instead, it will store those events and first emit them when the first observer subscribed to it. <br>
 * It will store "X" amount of recent events and will emit them to every new subscriber.
 * @author Neyney
 * @param <T>
 */
public class ColdSubject<T> extends Subject<T> {
	
	/*
	 * a data structure that contains all observers to notify when event occurs. can be any data structure.
	 */
	Set<Observer<T>> observers;
	
	/*
	 * a data structure that contains all previous events.
	 */
	LinkedList<T> coldData;
	
	/**
	 * amount of recent events to store.
	 */
	int amountOfRecent = 3;
	
	/**
	 * [Constructor] <br>
	 * Creates a new "ColdSubject" object, initializing the data structure that will contain observers,
	 * and initializing the queue of recent events.
	 */
	public ColdSubject() {
		this.observers = new HashSet<Observer<T>>();
		this.coldData = new LinkedList<T>();
	}
	
	/**
	 * [Constructor] <br>
	 * Creates a new "ColdSubject" object, initializing the data structure that will contain observers,
	 * and initializing the queue of recent events, the constructor receives recent amount argument as the maximum
	 * amount of recent events to keep in storage.
	 * @param recents - the amount of recent events to keep.
	 */
	public ColdSubject(int recents) {
		this();
		this.amountOfRecent = recents;
	}
	
	/**
	 * subscribing an observer to this observable, when subscribed, the observer will get notified about events. <br>
	 * this works the same as Hot Observable, the only change that upon subscribing, the observer will be notified
	 * about recent events too.
	 */
	@Override
	public void subscribe(Observer<T> o) {
		// add observer to the set.
		observers.add(o);
		
		// send recent data if any.
		Iterator<T> iter = coldData.iterator();
		if(!coldData.isEmpty()) { 
			while(iter.hasNext())  
				o.onEvent(iter.next());
		}
	}

	@Override
	public void unsubscribe(Observer<T> o) {
		observers.remove(o);
	}

	/**
	 * report/notify about an event to all observers, passing along the event's data.
	 * storing the new event in the 'recent's list', if there are too many events upon adding the new event
	 * the most outdated event is removed.
	 */
	@Override
	public void emitEvent(T data) {
		coldData.add(data);
		
		// if there are too many recent event then remove one.
		if(coldData.size() > amountOfRecent)
			coldData.remove(); // removes most outdated event.
		
		// notify observers.
		for(Observer<T> o : observers)
			o.onEvent(data);

	}
}

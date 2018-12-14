package behaviouralPattern.observables;

/**
 * an Observable interface, an observable as an object type which emit events and changes to it's observers. <br>
 * Observer can subscribe to an observable and be notified about occurring events and changes. <br>
 * @author Neyney
 * @param <T>
 */
public interface Observable <T> {
	
	/**
	 * subscribing an observer to this observable, when subscribed, the observer will get notified about events.
	 * @param o - Observer - an observer to add.
	 */
	public void subscribe(Observer<T> o);
	
	/**
	 * unsubscribing an observer to this observable, when unsubscribed, the observer will not get any notifications about events 
	 * from this observable any longer.
	 * @param o - Observer - an observer to remove/unsubscribe.
	 */
	public void unsubscribe(Observer<T> o);
	
	/**
	 * report/notify about an event to all observers, passing along the event's data.
	 * @param data - the event's data.
	 */
	public void emitEvent(T data);
	
}

package behaviouralPattern.observables;

/**
 * 
 * An observer interface, an observer is an object type that observes an "Observable" object type. <br>
 * When the observer subscribes to an observable, it will get notified about events of observable.
 * @author Neyney
 * @param <T>
 */
public interface Observer<T> {
	/**
	 * a function thats get called by an "Observable" type object when an event occurs. <br>
	 * it receives the event's data as argument.
	 * @param data - Event's data.
	 */
	public void onEvent(T data);
}

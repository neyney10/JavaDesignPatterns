package behaviouralPattern.observables;

import java.util.LinkedList;

/**
 * the Detective class in an example of an observer, it's observes an observable type object and
 * when an event occurs it prints the data along with the detective's name.
 * this is a "Cold" Observer, it is lazy, when getting notified about an event, it doesn't process it right away.
 * instead, it waits for a call on "work" type methods such as "workFirst" - making it process the first event received,
 * "workLast" about the most recent event received, and "workAll" to process all events.
 * @author Neyney
 * @param <T>
 */
public class ColdDetective<T> extends Detective<T> {

	LinkedList<T> data;
	
	/**
	 * [Constructor] <br>
	 * Creates a new "ColdDetective" object, initializing the events queue.
	 * @param n
	 */
	public ColdDetective(String n) {
		super(n);
		data = new LinkedList<T>();
	}
	
	@Override
	public void onEvent(T data) {
		this.data.add(data);
	}
	
	/**
	 * Work on the last (most outdated) event received.
	 */
	public void workLast() {
		if(data.size() > 0)
			super.onEvent(data.removeLast());
	}
	
	/**
	 * Work on the first (most recent) event received.
	 */
	public void workFirst() {
		if(data.size() > 0)
			super.onEvent(data.removeFirst());
	}
	
	/**
	 * Work on all events received so far.
	 */
	public void workAll() {
		int size = data.size();
		for(int i = 0 ; i < size ; i++)
			workFirst();
	}
	
	/**
	 * gets the amount of work there is to be done by this ColdDetective.
	 * @return number - the amount of events that hasn't handled yet.
	 */
	public int workAmount() {
		return data.size();
	}
	
	

}

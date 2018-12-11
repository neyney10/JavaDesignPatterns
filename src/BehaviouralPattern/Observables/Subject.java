package BehaviouralPattern.Observables;

import java.util.HashSet;
import java.util.Set;

public class Subject<T> implements Observable<T> {
	
	Set<Observer<T>> observers;
	
	public Subject() {
		this.observers = new HashSet<Observer<T>>();
	}
	
	@Override
	public void subscribe(Observer<T> o) {
		observers.add(o);
	}

	@Override
	public void unsubscribe(Observer<T> o) {
		observers.remove(o);
	}

	@Override
	public void emitEvent(T data) {
		for(Observer<T> o : observers)
			o.onEvent(data);
	}


}
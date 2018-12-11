package BehaviouralPattern.Observables;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class ColdSubject<T> extends Subject<T> {
	Set<Observer<T>> observers;
	LinkedList<T> coldData;
	
	public ColdSubject() {
		this.observers = new HashSet<Observer<T>>();
		this.coldData = new LinkedList<T>();
	}
	
	@Override
	public void subscribe(Observer<T> o) {
		observers.add(o);
		
		if(!coldData.isEmpty()) { 
			int size = coldData.size();
			for(int i = 0; i < size; i++)  {
				T d = coldData.removeFirst();
					o.onEvent(d);
			}
		}
	}

	@Override
	public void unsubscribe(Observer<T> o) {
		observers.remove(o);
	}

	@Override
	public void emitEvent(T data) {
		if(observers.size() == 0) {
			coldData.add(data);
			return;
		}
		
		for(Observer<T> o : observers)
			o.onEvent(data);

	}
}

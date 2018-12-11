package BehaviouralPattern.Observables;

import java.util.LinkedList;

public class ColdDetective<T> extends Detective<T> {

	LinkedList<T> data;
	
	public ColdDetective(String n) {
		super(n);
		data = new LinkedList<T>();
	}
	
	@Override
	public void onEvent(T data) {
		this.data.add(data);
	}
	
	public void workLast() {
		if(data.size() > 0)
			super.onEvent(data.removeLast());
	}
	
	public void workFirst() {
		if(data.size() > 0)
			super.onEvent(data.removeFirst());
	}
	
	public void workAll() {
		int size = data.size();
		for(int i = 0 ; i < size ; i++)
			workFirst();
	}
	
	

}

package Observables;

public interface observable <T> {
	public void subscribe(Observer<T> o);
	public void unsubscribe(Observer<T> o);
	public void emitEvent(T data);
	
}

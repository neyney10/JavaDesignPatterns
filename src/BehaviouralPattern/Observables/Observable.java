package BehaviouralPattern.Observables;

public interface Observable <T> {
	public void subscribe(Observer<T> o);
	public void unsubscribe(Observer<T> o);
	public void emitEvent(T data);
	
}

package BehaviouralPattern.Observables;

public interface Observer<T> {
	
	public void onEvent(T data);
}

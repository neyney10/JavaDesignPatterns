package BehaviouralPattern.Observables;

public class Detective<T> implements Observer<T>{
	private String name;
	
	public Detective(String n) {
		this.name = n;
	}
	
	@Override
	public void onEvent(T data) {
		System.out.println(name+" GOT IT : "+data.toString());
	}
	
	
}

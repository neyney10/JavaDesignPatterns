package behaviouralPattern.observables;

/**
 * the Detective class in an example of an observer, it's observes an observable type object and
 * when an event occurs it prints the data along with the detective's name.
 * this is a "Hot" Observer.
 * @author Neyney
 *
 * @param <T>
 */
public class Detective<T> implements Observer<T>{
	
	// the detective name.
	private String name;
	
	/**
	 * [Constructor] <br>
	 * Creates a new "Detective Object".
	 * @param n
	 */
	public Detective(String n) {
		this.name = n;
	}
	
	@Override
	public void onEvent(T data) {
		System.out.println(name+" GOT IT : "+data.toString());
	}
	
	
}

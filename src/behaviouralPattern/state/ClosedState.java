package behaviouralPattern.state;

public class ClosedState implements State {
	
	private final String name = "Closed";
	
	@Override
	public void print(String text) {
		System.out.println("Sorry, the console is closed... please try again later");
	}

	@Override
	public String getStateName() {
		return name;
	}
}

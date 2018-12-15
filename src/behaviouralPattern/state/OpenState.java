package behaviouralPattern.state;

public class OpenState implements State{

	private final String name = "Open";
	
	@Override
	public void print(String text) {
		System.out.println("Here is your text: "+text);
	}

	@Override
	public String getStateName() {
		return name;
	}
	
}

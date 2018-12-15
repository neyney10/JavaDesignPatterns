package behaviouralPattern.state;

public class myConsolePrinter {

	private State state;
	
	public myConsolePrinter() {
		state = new OpenState();
	}

	public void printMyText(String text) {
		state.print(text);
	}
	
	public void setState(State state) {
		this.state = state;
	}

}

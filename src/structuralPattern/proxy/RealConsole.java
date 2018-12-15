package structuralPattern.proxy;

public class RealConsole implements Console {

	@Override
	public void print(String text) {
		System.out.println("Console: "+text);
	}

}

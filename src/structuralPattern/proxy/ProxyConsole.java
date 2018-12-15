package structuralPattern.proxy;

public class ProxyConsole implements Console {

	private RealConsole realConsole;
	private int number;
	
	public ProxyConsole(RealConsole c) {
		this.realConsole = c;
		this.number = (int) (Math.random()*1000);
	}
	
	@Override
	public void print(String text) {
		if(text.contains("HATE"))
			text = censor(text, "HATE");
		
		realConsole.print("[Via Proxy "+number+"] "+text);
		
	}
	
	private String censor(String text, String censor) {
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < censor.length() ;i++)
			sb.append('*');
		
		return text.replace(censor ,sb.toString());
	}
	

}

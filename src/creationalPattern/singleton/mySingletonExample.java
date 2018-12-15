package creationalPattern.singleton;

public class mySingletonExample {
	
	private static mySingletonExample instance;
	private int num;
	
	
	private mySingletonExample() { 
		System.out.println("A new instance of this mySingletonExample is created!");
	}
	
	public static mySingletonExample getInstance() {
		if(instance == null)
			instance = new mySingletonExample();
		
		return instance;
	}

	/**
	 * @return the num
	 */
	public int getNum() {
		return num;
	}

	/**
	 * @param num the num to set
	 */
	public void setNum(int num) {
		this.num = num;
	}
}

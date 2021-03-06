package tES;

public final class mySingleton {

	private static mySingleton instance; // NULL BE DEFAULT
	private int num;
	
	
	/**
	 * SHOULD REMAIN PRIVATE AS SINGLETON
	 */
	private mySingleton() {}
	
	public static synchronized mySingleton getInstance() {
		if(instance == null)
			instance = new mySingleton();
		
		return instance;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}
	
	
	public static void main(String[] args) {
		mySingleton s = mySingleton.getInstance();
		s.setNum(25);
		System.out.println(s.getNum());
		
		
		mySingleton s2 = mySingleton.getInstance();
		System.out.println(s2.getNum());
		s2.setNum(33);
		
		mySingleton s3 = mySingleton.getInstance();
		System.out.println(s3.getNum());
	}
	
	
	
}

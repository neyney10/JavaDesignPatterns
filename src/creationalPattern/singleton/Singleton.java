package creationalPattern.singleton;

/**
 * a Singleton pattern belongs to the creational patterns, a singleton must have only one instance.
 * this can be achieved by limiting the ways the user can instantiate singleton objects, therefore we
 * shall hide the constructor, and handle the instance creation ourselves using the "getInstance()" function, which 
 * will return the single instance created by this class, the instantiation process is 'lazy', means that the
 * class will not create a new instance unless it doesn't have an already created instance, if there is an instance,
 * then the "getInstance()" function will return the very same instance. <br>
 * The class is considered "final" because we don't want other programmers to modify our class.
 * @author Neyney
 */
public final class Singleton {
	
	/*
	 * The only instance of this class is stored here.
	 */
	private static Singleton instance; // NULL by default
	
	/**
	 * [Constructor] <br>
	 * This should remain private as part of the Singleton design pattern, only this class methods and functions can create
	 * a new instance of this class.
	 */
	private Singleton() {}
	
	/**
	 * get this class instance, will be created only once at the first call to this function, and any successive calls
	 * to this function will return the first instance created.
	 * @return the single object instance of this class.
	 */
	public static Singleton getInstance() {
		// if there isn't already an instance of this class, then instantiate one.
		if(instance == null)
			instance = new Singleton();
		
		return instance;
	}
}

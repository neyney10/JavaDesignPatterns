package structuralPattern.flyweight;

import java.util.HashMap;

public final class Flyweight {
	
	private static final HashMap<Type, String> instances = new HashMap<>();
	
	/**
	 * a factory pattern
	 * @param type
	 * @return 
	 */
	public static String getString(Type type) {
		String instance = instances.get(type);
		
		if(instance == null) {
			switch(type) {
				case head:
					instance = new String("This is the Headline! YEAHHH");
					break;
				case body:
					instance = new String("This is the body! here is the content...");
					break;
				case footer:
					instance = new String("This is the footer! there is nothing here besides ads...");
					break;
			}
			
			instances.put(type, instance);
		}
		
		return instance;
	}
}

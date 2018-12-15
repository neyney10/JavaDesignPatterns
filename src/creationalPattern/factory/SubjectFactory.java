package creationalPattern.factory;

import behaviouralPattern.observables.ColdSubject;
import behaviouralPattern.observables.Subject;

/**
 * a factory that creates subject observable from the Observables package, can create hot and cold observable <br>
 * @author Student
 */
public class SubjectFactory<T> {
	
	public SubjectFactory() {}
	
	/**
	 * Creates a regular "Subject" object, as it considerate to be a "Hot observable"
	 * @return Subject
	 */
	public Subject<T> createHotSubject() {
		return new Subject<T>();
	}
	
	/**
	 * Creates a "ColdSubject" object.
	 * @return ColdSUbject
	 */
	public ColdSubject<T> createColdSubject() {
		return new ColdSubject<T>();
	}
	
	/**
	 * Creates a "ColdSubject" object. with recents as the number of events to store.
	 * @return ColdSUbject
	 */
	public ColdSubject<T> createColdSubject(int recents) {
		return new ColdSubject<T>(recents);
	}

}

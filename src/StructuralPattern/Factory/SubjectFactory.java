package StructuralPattern.Factory;

import BehaviouralPattern.Observables.ColdSubject;
import BehaviouralPattern.Observables.Subject;

/**
 * a factory that creates subject observable  from the Observables package, can create hot and cold observable <br>
 * @author Student
 */
public class SubjectFactory<T> {
	
	public SubjectFactory() {}
	
	public Subject<T> createHotSubject() {
		return new Subject<T>();
	}
	
	public ColdSubject<T> createColdSubject() {
		return new ColdSubject<T>();
	}

}

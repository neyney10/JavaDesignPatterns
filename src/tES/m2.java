package tES;


import behaviouralPattern.observables.*;
import creationalPattern.factory.*;

public class m2 {

	public static void main(String[] args) {
		SubjectFactory<String> sf = new SubjectFactory<String>();
		Subject<String> s = sf.createHotSubject();

		A a1 = new m2().new A(s);
		A a2 = new m2().new A(s);

		B b = new m2().new B(s);
		
		a1.start();
		a2.start();
		b.start();
		
	}
	
	class A extends Thread {
		Subject<String> s;
		public A(Subject<String> s) {
			this.s = s;
			Detective<String> o1 = new Detective("1 name[");
			s.subscribe(o1);
			
		}
		
		
		@Override
		public void run() {
			
		}
	}
	
	class B extends Thread {
		Subject<String> s;
		public B(Subject<String> s) {
			this.s = s;
		}
		
		@Override
		public void run() {
			int i = 0;
			while(true)
			{
				
				i++;
				s.emitEvent("TEST "+i);
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

}

package tES;

import java.util.LinkedList;

import behaviouralPattern.observables.*;
import behaviouralPattern.state.ClosedState;
import behaviouralPattern.state.myConsolePrinter;
import behaviouralPattern.visitor.Manager;
import behaviouralPattern.visitor.PersonVisitor;
import behaviouralPattern.visitor.Visitable;
import behaviouralPattern.visitor.Visitor;
import behaviouralPattern.visitor.Worker;
import creationalPattern.factory.*;
import structuralPattern.flyweight.Flyweight;
import structuralPattern.flyweight.Type;
import structuralPattern.proxy.ProxyConsole;
import structuralPattern.proxy.RealConsole;

public class m {

	private int data = 0;
	
	private final Object lock = new Object();
	
	public static void main(String[] args) {
		// Visitor
		LinkedList<Visitable> persons = new LinkedList<>();
		Worker w1 = new Worker(1000,200);
		Worker w2 = new Worker(2312, 500);
		Manager man1 = new Manager(3000,333);
		
		persons.add(w1);
		persons.add(w2);
		persons.add(man1);
		
		Visitor myVisitor = new PersonVisitor();
		
		persons.forEach((person) -> System.out.println(person.accept(myVisitor)));
		
		float totalCompanyMoneySpent = 0;
		for (Visitable person : persons) {
			totalCompanyMoneySpent += person.accept(myVisitor);
		}
		
		System.out.println("Total company HR cost: "+totalCompanyMoneySpent);
		
		// state
		myConsolePrinter consolePrinter = new myConsolePrinter();
		consolePrinter.printMyText("Hello!");
		consolePrinter.setState(new ClosedState());
		consolePrinter.printMyText("Hello again!");
		
		// proxy - protection proxy
		ProxyConsole console1 = new ProxyConsole(new RealConsole());
		ProxyConsole console2 = new ProxyConsole(new RealConsole());
		console1.print("Hello World");
		console1.print("This is the first proxy");
		console2.print("Hello World");
		console2.print("This is the second proxy");
		
		console1.print("this is a HATE sentence");
		
		
		// flyweight
		System.out.println(Flyweight.getString(Type.head));
		System.out.println(Flyweight.getString(Type.body));
		System.out.println(Flyweight.getString(Type.footer));
		
		
		//COLD DETECTIVE
		SubjectFactory<String> factory = new SubjectFactory<String>();
		Subject<String> coldS = factory.createColdSubject();
		ColdDetective<String> cd = new ColdDetective<String>("cold det");
		ColdDetective<String> cd2 = new ColdDetective<String>("cold det2");

		coldS.emitEvent("TEST1");
		coldS.emitEvent("TEST2");
		coldS.subscribe(cd);
		coldS.emitEvent("TEST3");
		coldS.emitEvent("TEST4");
		coldS.emitEvent("TEST5");
		coldS.subscribe(cd2);
		
		cd.workAll();
		cd2.workAll();
		
		//FACTORY WITH OBSERVABLES
//		SubjectFactory<String> factory = new SubjectFactory<String>();
//		Subject<String> coldS = factory.createColdSubject();
//		coldS.emitEvent("TEST1");
//		coldS.emitEvent("TEST2");
//		coldS.emitEvent("TEST3");
//		Detective<String> det1 = new Detective<>("Det1!");
//		Detective<String> det2 = new Detective<>("Det2!");
//		coldS.subscribe(det1);
//		coldS.subscribe(det2);
//		coldS.emitEvent("TEST4");
		
		//SIMPLE OBSERVER AND OBSERVABLE EXAMPLE
//		Subject<String> sub = new Subject<>();
//		Detective<String> det1 = new Detective<>("Det1!");
//		Detective<String> det2 = new Detective<>("Det2!");
//		sub.subscribe(det1);
//		sub.subscribe(det2);
//		sub.emitEvent("HELLO!");
//		sub.unsubscribe(det1);
//		sub.emitEvent("THIS IS ME second");
		
		
		// THREADING CONSUMER PRODUCER PROBLEM
//		m mtest = new m();
//		P p = mtest.new P();
//		C c = mtest.new C();
//		p.start();
//		c.start();
	}
	
	public  int getData() {
		synchronized (lock) {
			
		
		try {
			System.out.println("GETDATA going to sleep");
			Thread.sleep(222);
			System.out.println("GETDATA SLEPT");
		} catch (InterruptedException e1) {
	
			e1.printStackTrace();
		}
		
		while(data == 0)
			try {
				lock.wait();
			} catch (InterruptedException e) {
		
				e.printStackTrace();
			}
		
		data--;
		System.out.println("[-] used resource: "+data);
		if(data ==0)
			lock.notify();
		return data;
		}
		
	}

	public void setData(int data) {
		synchronized (lock) {
			
		
		try {
			System.out.println("setdata going to sleep");
			Thread.sleep(222);
			System.out.println("setdata SLEPT");
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		while(this.data > 0)
			try {
				lock.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		this.data = data;
		System.out.println("[+] gain resource: "+data);
		lock.notify();
		}
	}

	class C extends Thread {
		@Override
		public void run() {
			while(true)
				m.this.getData();
		}
	}
	
	class P extends Thread {
		@Override
		public void run() {
			for(int i=0;i<5;i++)
				m.this.setData(i);
			
		}
	}

}

package behaviouralPattern.visitor;


public class PersonVisitor implements Visitor {

	@Override
	public float visit(Worker worker) {
		return worker.getSalary() - worker.getCarRentCost();
	}

	@Override
	public float visit(Manager manager) {
		return manager.getSalary() +  manager.getBonus();
	}

}

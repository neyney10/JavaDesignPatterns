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
	
	@Override
	public float visit(ExternalWorker externalWorker) {
		return (externalWorker.getSalary() +  externalWorker.getExpertCost())*(1-externalWorker.getTax());
	}

}

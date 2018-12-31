package behaviouralPattern.visitor;

public class Worker implements Visitable {
	private float salary;
	private float carRentCost;
	
	public Worker(float salary, float rentCost) {
		this.setSalary(salary);
		this.setCarRentCost(rentCost);
	}
	
	
	
	@Override
	public float accept(Visitor visitor) {
		return visitor.visit(this);
	}



	public float getSalary() {
		return salary;
	}



	public void setSalary(float salary) {
		this.salary = salary;
	}



	public float getCarRentCost() {
		return carRentCost;
	}



	public void setCarRentCost(float carRentCost) {
		this.carRentCost = carRentCost;
	}

}

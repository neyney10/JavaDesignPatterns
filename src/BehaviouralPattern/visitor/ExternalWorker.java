package behaviouralPattern.visitor;

public class ExternalWorker implements Visitable {
	private float salary;
	private float expertCost;
	private float tax; //%
	
	public ExternalWorker(float salary, float expertiseCost, float tax) {
		this.salary = salary;
		this.expertCost = expertiseCost;
		this.tax = tax;
	}
	
	@Override
	public float accept(Visitor visitor) {
		return visitor.visit(this);
	}

	public float getTax() {
		return tax;
	}

	public void setTax(float tax) {
		this.tax = tax;
	}

	public float getExpertCost() {
		return expertCost;
	}

	public void setExpertCost(float expertCost) {
		this.expertCost = expertCost;
	}

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}

}

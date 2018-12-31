package behaviouralPattern.visitor;

public class Manager implements Visitable {
	private float salary;
	private float bonus;
	
	public Manager(float salary, float bonus) {
		this.salary = salary;
		this.bonus = bonus;
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

	public float getBonus() {
		return bonus;
	}

	public void setBonus(float bonus) {
		this.bonus = bonus;
	}

}

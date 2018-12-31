package behaviouralPattern.visitor;

public interface Visitor {
	float visit(Worker worker);
	float visit(Manager manager);
}

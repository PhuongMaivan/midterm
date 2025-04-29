package hus.oop.gk2023_2024.decorator;

public class Cheese extends ToppingDecorator {
	public Cheese(Bread bread) {
		this.bread = bread;
	}

	public String getDescription() {
		return bread.getDescription() + " + Cheese";
	}

	public double cost() {
		return bread.cost() + 1.0;
	}

	@Override
	public String toString() {
		return getDescription() + ", Cost " + cost();
	}
}
package hus.oop.gk2023_2024.decorator;

public abstract class ToppingDecorator extends Bread {
	protected Bread bread;
	
	public abstract String getDescription();

	public Bread getBread() {
		return this.bread;
	}
}

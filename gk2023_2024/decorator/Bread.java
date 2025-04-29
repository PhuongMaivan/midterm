package hus.oop.gk2023_2024.decorator;

public abstract class Bread {
	protected String description;

	public String getDescription() {
		return description;
	}

	public abstract double cost();
}
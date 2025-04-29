package com.decorator;

public class Cheese extends ToppingDecorator {
	public Cheese(Bread bread) {
		this.bread = bread;
	}
 
	public String getDescription() {
		return this.bread.getDescription() + ", Cheese";
	}
 
	public double cost() {
		return this.bread.cost() + 1.0;
	}
}

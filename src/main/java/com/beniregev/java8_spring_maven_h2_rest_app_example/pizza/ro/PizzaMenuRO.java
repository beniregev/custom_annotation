package com.beniregev.java8_spring_maven_h2_rest_app_example.pizza.ro;

import com.beniregev.java8_spring_maven_h2_rest_app_example.base.ro.BaseUpdatableRO;

public class PizzaMenuRO extends BaseUpdatableRO {

	private static final long serialVersionUID = 1L;

	private String name;

	private double price;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
}

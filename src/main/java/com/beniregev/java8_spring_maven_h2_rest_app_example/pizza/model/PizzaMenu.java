package com.beniregev.java8_spring_maven_h2_rest_app_example.pizza.model;

import com.beniregev.java8_spring_maven_h2_rest_app_example.base.BaseUpdatebleEntity;
import com.beniregev.java8_spring_maven_h2_rest_app_example.base.ro.BaseRO;
import com.beniregev.java8_spring_maven_h2_rest_app_example.pizza.ro.PizzaMenuRO;
import com.beniregev.java8_spring_maven_h2_rest_app_example.utils.MyNewAnnotation;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "pizza_menu")
public class PizzaMenu extends BaseUpdatebleEntity {

	private static final long serialVersionUID = 1L;

	// ------------------------ Constants -----------------------
	// ------------------------ Fields --------------------------
	@MyNewAnnotation
	private String name;
	@MyNewAnnotation
	private double price;

	private boolean isDery;
	private int bakeTime = 18;

	public PizzaMenu() {
	}

	@Column(name = "name", nullable = false)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "price", nullable = false)
	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	@SuppressWarnings("unchecked")
	protected <T extends BaseRO> T newRepresentation() {
		PizzaMenuRO ro = new PizzaMenuRO();
		ro.setName(getName());
		ro.setPrice(getPrice());
		return (T) ro;
	}

	// ------------------------ Private methods -----------------
}

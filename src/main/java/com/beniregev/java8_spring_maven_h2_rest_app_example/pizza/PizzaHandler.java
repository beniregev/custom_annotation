package com.beniregev.java8_spring_maven_h2_rest_app_example.pizza;

import com.beniregev.java8_spring_maven_h2_rest_app_example.pizza.model.PizzaMenu;

import java.util.List;

public interface PizzaHandler {

	List<PizzaMenu> getPizzaMenu();

	List<PizzaMenu> getPizzaMenu(String menuName, Integer minPrice, Integer maxPrice);

	PizzaMenu getPizza(Long id);
}

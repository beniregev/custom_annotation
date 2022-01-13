package com.beniregev.java8_spring_maven_h2_rest_app_example.pizza;

import com.beniregev.java8_spring_maven_h2_rest_app_example.pizza.model.PizzaMenu;

import java.util.List;

public interface PizzaDao {

	List<PizzaMenu> getPizzaMenus();

	List<PizzaMenu> getPizzaMenus(String menuName, Integer minPrice, Integer maxPrice);

	PizzaMenu getPizza(Long id);
}

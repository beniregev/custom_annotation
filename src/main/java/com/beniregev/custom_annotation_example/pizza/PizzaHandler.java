package com.beniregev.custom_annotation_example.pizza;

import com.beniregev.custom_annotation_example.pizza.model.PizzaMenu;

import java.util.List;

public interface PizzaHandler {

	List<PizzaMenu> getPizzaMenu();

	List<PizzaMenu> getPizzaMenu(String menuName, Double minPrice, Double maxPrice);

	PizzaMenu getPizza(Long id);
}

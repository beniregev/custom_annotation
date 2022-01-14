package com.beniregev.custom_annotation_example.pizza;

import com.beniregev.custom_annotation_example.pizza.model.PizzaMenu;

import java.util.List;

public interface PizzaDao {

	List<PizzaMenu> getPizzaMenus();

	List<PizzaMenu> getPizzaMenus(String menuName, Double minPrice, Double maxPrice);

	PizzaMenu getPizza(Long id);
}

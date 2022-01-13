package com.beniregev.java8_spring_maven_h2_rest_app_example.pizza;

import com.beniregev.java8_spring_maven_h2_rest_app_example.base.ro.ResultRO;

public interface PizzaService {

	ResultRO getMenu();

	ResultRO getMenu(String menuName, Integer minPrice, Integer maxPrice);

	ResultRO orderPizza(Long id);
}

package com.beniregev.custom_annotation_example.pizza;

import com.beniregev.custom_annotation_example.base.ro.ResultRO;

public interface PizzaService {

	ResultRO getMenu();

	ResultRO getMenu(String menuName, Integer minPrice, Integer maxPrice);

	ResultRO orderPizza(Long id);
}

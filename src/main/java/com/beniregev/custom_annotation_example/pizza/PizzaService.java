package com.beniregev.custom_annotation_example.pizza;

import com.beniregev.custom_annotation_example.base.ro.ResultRO;

public interface PizzaService {

	ResultRO getMenu();

	ResultRO getMenu(String menuName, Double minPrice, Double maxPrice);

	ResultRO orderPizza(Long id);
}

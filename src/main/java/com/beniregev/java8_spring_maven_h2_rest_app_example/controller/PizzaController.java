package com.beniregev.java8_spring_maven_h2_rest_app_example.controller;

import com.beniregev.java8_spring_maven_h2_rest_app_example.base.ro.ResultRO;
import com.beniregev.java8_spring_maven_h2_rest_app_example.pizza.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Controller for work with Pizza REST api service.
 */
@Controller
public class PizzaController {

	@Autowired
	private PizzaService pizzaService;

	/**
	 * TODO - 1:
	 * Currently this api call returns all pizza menus from the db.
	 * Add to this api call the ability to search for a pizza menu by name and / or between minPrice / maxPrice.
	 * e.g. /pizza/menu?name=chees&maxPrice=10 should return pizza data for pizza 'Cheesy Crust'
	 * e.g. /pizza/menu?minPrice=0&maxPrice=1 should return pizza data for pizza 'Margherita'
	 *
	 * @param request
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/pizza/menu", method = RequestMethod.GET)
	public ResultRO getMenu(@RequestParam(value = "name", required = false) String menuName,
							@RequestParam(value = "minPrice", required = false) Integer minPrice,
							@RequestParam(value = "maxPrice", required = false) Integer maxPrice,
							HttpServletRequest request,
							HttpServletResponse response) {
		if (menuName != null || minPrice != null || maxPrice != null) {
			return pizzaService.getMenu(menuName,minPrice, maxPrice);
		} else {
			return pizzaService.getMenu();
		}
	}
	/**
	 * TODO - 2:
	 * 1. Create a new custom java annotation.
	 * 2. Add the new custom annotation on PizzaMenu's name & price fields.
	 * 3. Implement exiting empty method Utils.extractQueryString which extracts a query string
	 * (e.g. fieldName=fieldValue&fieldName2=fieldValue2) from every PizzaMenu field which is
	 * annotated with the new custom java annotation.
	 * e.g When calling /pizza/order?id=3 the result should be 'name=Sicilian&price=2.99'
	 *
	 * @param id
	 * @param request
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/pizza/order", method = RequestMethod.POST)
	public ResultRO orderPizza(@RequestParam Long id, HttpServletRequest request, HttpServletResponse response) {
		return pizzaService.orderPizza(id);
	}
}

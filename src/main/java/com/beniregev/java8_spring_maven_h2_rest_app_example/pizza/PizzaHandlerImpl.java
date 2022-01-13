package com.beniregev.java8_spring_maven_h2_rest_app_example.pizza;

import com.beniregev.java8_spring_maven_h2_rest_app_example.pizza.model.PizzaMenu;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component(value = "pizzaHandler")
public class PizzaHandlerImpl implements PizzaHandler {

	protected Log log = LogFactory.getLog(getClass());

	@Autowired
	private PizzaDao pizzaDao;

	@Override
	@Transactional(readOnly = true)
	public List<PizzaMenu> getPizzaMenu() {
		return pizzaDao.getPizzaMenus();
	}

	@Override
	@Transactional(readOnly = true)
	public List<PizzaMenu> getPizzaMenu(String menuName, Integer minPrice, Integer maxPrice) {
		return pizzaDao.getPizzaMenus(menuName, minPrice, maxPrice);
	}

	@Override
	@Transactional(readOnly = true)
	public PizzaMenu getPizza(Long id) {
		return pizzaDao.getPizza(id);
	}
}

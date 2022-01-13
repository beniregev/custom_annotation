package com.beniregev.java8_spring_maven_h2_rest_app_example.pizza;

import com.beniregev.java8_spring_maven_h2_rest_app_example.base.ro.ResultRO;
import com.beniregev.java8_spring_maven_h2_rest_app_example.pizza.model.PizzaMenu;
import com.beniregev.java8_spring_maven_h2_rest_app_example.pizza.ro.PizzaMenuRO;
import com.beniregev.java8_spring_maven_h2_rest_app_example.utils.MyNewAnnotation;
import com.beniregev.java8_spring_maven_h2_rest_app_example.utils.Utils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("pizzaService")
public class PizzaServiceImpl implements PizzaService {

	protected Log log = LogFactory.getLog(getClass());

	@Autowired
	private PizzaHandler pizzaHandler;

	@Override
	public ResultRO getMenu() {
		ResultRO resultRO = new ResultRO();

		try {
			List<PizzaMenu> menu = pizzaHandler.getPizzaMenu();
			List<PizzaMenuRO> menuRO = new ArrayList<>();

			for(PizzaMenu pizzaMenu : menu) {
				menuRO.add(pizzaMenu.getRepresentation());
			}

			resultRO.setResult(menuRO);
		} catch(Exception e) {
			resultRO.setSuccess(false);
			resultRO.setError(e.getMessage());
		}

		return resultRO;
	}

	@Override
	public ResultRO getMenu(String menuName, Integer minPrice, Integer maxPrice) {
		ResultRO resultRO = new ResultRO();

		try {
			List<PizzaMenu> menu = pizzaHandler.getPizzaMenu(menuName, minPrice, maxPrice);
			List<PizzaMenuRO> menuRO = new ArrayList<>();

			for(PizzaMenu pizzaMenu : menu) {
				menuRO.add(pizzaMenu.getRepresentation());
			}

			resultRO.setResult(menuRO);
		} catch(Exception e) {
			resultRO.setSuccess(false);
			resultRO.setError(e.getMessage());
		}

		return resultRO;
	}

	@Override
	public ResultRO orderPizza(Long id) {
		ResultRO resultRO = new ResultRO();

		PizzaMenu pizzaMenu = pizzaHandler.getPizza(id);
		String pizzaQueryString = Utils.extractQueryString(pizzaMenu, null);

		resultRO.setResult(pizzaQueryString);

		return resultRO;
	}
}

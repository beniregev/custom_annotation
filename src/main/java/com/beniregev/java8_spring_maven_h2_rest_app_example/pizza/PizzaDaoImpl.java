package com.beniregev.java8_spring_maven_h2_rest_app_example.pizza;

import com.beniregev.java8_spring_maven_h2_rest_app_example.base.BaseDaoImpl;
import com.beniregev.java8_spring_maven_h2_rest_app_example.pizza.model.PizzaMenu;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@SuppressWarnings("ALL")
@Repository
public class PizzaDaoImpl extends BaseDaoImpl implements PizzaDao {

	protected Log log = LogFactory.getLog(getClass());

	@Autowired
	private PizzaDao pizzaDao;

	@Override
	public List<PizzaMenu> getPizzaMenus() {
		Criteria criteria = getCurrentSession().createCriteria(PizzaMenu.class);
		return criteria.list();
	}

	@Override
	public List<PizzaMenu> getPizzaMenus(String menuName, Integer minPrice, Integer maxPrice) {
		Criteria criteria = getCurrentSession().createCriteria(PizzaMenu.class);
		Criterion criteriaMenuName = null;
		if (menuName != null && !menuName.isEmpty()) {
			criteria.add(Restrictions.eq("name", menuName));
		}

		//	Build criteria for minPrice and maxPrice under logical conditions
		Criterion criteriaMinPrice = null;
		Criterion criteriaMaxPrice = null;
		if (!((minPrice == null || minPrice < 1) && (maxPrice == null || maxPrice < 1))) {
			if (minPrice != null && minPrice >= 0) {
				criteriaMinPrice = Restrictions.ge("price", minPrice);
			} else {
				criteriaMinPrice = Restrictions.ge("price", 0);
			}
			if (maxPrice != null && maxPrice > 0) {
				criteriaMaxPrice = Restrictions.le("price", maxPrice);
			}
		}

		//	Don't include criteria for maxPrice if it's null
		if (criteriaMaxPrice != null) {
			LogicalExpression andExpression = Restrictions.and(criteriaMinPrice, criteriaMaxPrice);
			criteria.add(andExpression);
		} else {
			criteria.add(criteriaMinPrice);
		}
		return criteria.list();
	}

	@Override
	public PizzaMenu getPizza(Long id) {
		return findObject(PizzaMenu.class, id);
	}
}

package com.beniregev.java8_spring_maven_h2_rest_app_example.utils;

import java.lang.reflect.Field;

public class Utils {

	private Utils() {
		throw new UnsupportedOperationException();
	}

	/**
	 * Extracts a query string (e.g. fieldName=fieldValue&fieldName2=fieldValue2) from every field which is annotated with the given 'annotation'
	 *
	 * @param source
	 * @param annotation
	 * @return
	 */
	public static String extractQueryString(Object source, Class annotation) {
		Class<?> classesToVerify = source.getClass();
		Field[] fields = classesToVerify.getDeclaredFields();

		StringBuilder result = null;
		for (Field field : fields) {
			if (field.getAnnotation(MyNewAnnotation.class) instanceof MyNewAnnotation) {
				field.setAccessible(true);
				try {
					result.append(field.getName()).append("=").append(field.get(source)).append("&");
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}
			}
		}
		//	Delete last "&"
		result.deleteCharAt(result.lastIndexOf("&"));

		return result.toString();
	}
}

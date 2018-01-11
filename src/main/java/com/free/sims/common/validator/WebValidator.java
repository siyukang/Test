package com.free.sims.common.validator;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.regex.Pattern;

import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

/**
 * @author liuzeke
 * @version 1.0
 */
public class WebValidator {

	private WebValidator() {
	}

	/**
	 * @author liuzeke
	 * @param obj
	 */
	public static Message validate(Object obj, Type type) {

		Assert.notNull(obj, "The obj must not be null!");
		Assert.notNull(obj, "The type must not be null!");

		StringBuilder sb = new StringBuilder();
		boolean flag = false;
		for (Field field : obj.getClass().getDeclaredFields()) {
			Matches matches = (Matches) field.getAnnotation(Matches.class);
			Object o = null;
			try {
				o = getMethod(obj.getClass(), getGetMethod(field.getName())).invoke(obj);
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
			String os = o == null ? "" : o.toString();
			if (matches == null || !matching(matches.type(), type))
				continue;
			field.setAccessible(true);
			if (!Pattern.compile(matches.pattern()).matcher(os).matches()) {
				if (StringUtils.isEmpty(matches.name()))
					sb.append(field.getName()).append(matches.value());
				else
					sb.append(matches.name()).append(matches.value());
				flag = true;
			}
		}
		return flag ? new Message(true, sb.toString()) : new Message(false, null);
	}

	/**
	 * @author liuzeke
	 * @return
	 */
	private static String getGetMethod(String field) {
		return "get" + Character.toUpperCase(field.charAt(0)) + field.substring(1);
	}

	/**
	 * @author liuzeke
	 * @param clazz
	 * @param methodName
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static Method getMethod(Class clazz, String methodName) {
		try {
			return clazz.getDeclaredMethod(methodName);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * @author liuzeke
	 * @param annotationType
	 * @param reqType
	 * @return
	 */
	private static boolean matching(final Type annotationType, Type reqType) {
		return (annotationType == null || reqType == null) ? false
				: ((annotationType == reqType) ? true
						: ((annotationType == Type.ADD_UPDATE && reqType == Type.ADD) ? true
								: ((annotationType == Type.ADD_UPDATE && reqType == Type.UPDATE) ? true : false)));
	}
}
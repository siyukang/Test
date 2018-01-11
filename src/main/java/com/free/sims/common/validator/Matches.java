package com.free.sims.common.validator;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author liuzeke
 * @version 1.0
 */
@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Matches {

	String pattern();

	String value() default "输入不合法;";

	String name() default "";

	Type type() default Type.ADD_UPDATE;
}
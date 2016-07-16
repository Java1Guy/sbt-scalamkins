package com.peopledesigned;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface LambdaFunction {
  public String path();
	public String inputModel() default "";
	public String outputModel() default "";
}
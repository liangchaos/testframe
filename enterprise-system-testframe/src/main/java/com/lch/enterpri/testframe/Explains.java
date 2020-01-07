package com.lch.enterpri.testframe;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**
 * Description:方法说明描述 <br>
 * User: Administrator-LiangChao<br>
 * Date: 2019-12-31<br>
 * Time: 1:17
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Explains {

  /** 说明信息 */
  public String value() default "";
}

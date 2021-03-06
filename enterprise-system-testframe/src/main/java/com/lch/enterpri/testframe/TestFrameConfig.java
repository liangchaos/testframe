package com.lch.enterpri.testframe;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Description:TestFrame 自定义配置文件 <br>
 * User: Administrator-LiangChao<br>
 * Date: 2019-12-31<br>
 * Time: 1:17
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface TestFrameConfig {

  /** TestFrame 框架配置文件路径 类路径加:classpath: */
  String value();
}

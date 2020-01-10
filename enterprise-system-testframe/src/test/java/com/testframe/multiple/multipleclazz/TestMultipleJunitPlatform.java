package com.testframe.multiple.multipleclazz;

import com.lch.enterpri.testframe.TestFrameConfig;
import com.lch.enterpri.testframe.multiple.MultipleJunitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.runner.RunWith;

/**
 * @program: EnterpriseSystem<br>
 * @author: LiangChao<br>
 * @description: 多类测试平台<br>
 * @create: 2020-01-09 15:11
 */
@RunWith(MultipleJunitPlatform.class)
@SelectClasses({
  TestClassOne.class,
  TestClassTwo.class,
  TestClassThree.class,
  TestClassFour.class,
  TestClassFive.class
})
@TestFrameConfig(value = "classpath:/testframe.config.two.yml")
public class TestMultipleJunitPlatform {}

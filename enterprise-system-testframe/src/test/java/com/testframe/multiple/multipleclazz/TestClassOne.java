package com.testframe.multiple.multipleclazz;

import com.lch.enterpri.testframe.Explains;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.Random;

/**
 * @program: EnterpriseSystem<br>
 * @author: LiangChao<br>
 * @description: 测试类<br>
 * @create: 2020-01-09 17:13
 */
@Log4j2
public class TestClassOne {
  private static Random RM = new Random();

  // JUnit4 与 JUnit 5 常用注解对比
  //
  //  JUnit4              JUnit5	          说明
  //  @Test	              @Test	              表示该方法是一个测试方法。JUnit5与JUnit4的@Test注解不同的是，它没有声明任何属性，因为
  //                                          JUnit Jupiter中的测试扩展是基于它们自己的专用注解来完成的。这样的方法会被继承，除非它
  //                                          们被覆盖
  //  @BeforeClass        @BeforeAll          表示使用了该注解的方法应该在当前类中所有使用了@Test @RepeatedTest,
  //                                          @ParameterizedTest或者@TestFactory注解的方法之前 执行；
  //  @AfterClass         @AfterAll           表示使用了该注解的方法应该在当前类中所有使用了@Test、@RepeatedTest、
  //                                          @ParameterizedTest或者@TestFactory注解的方法之后执行；
  //  @Before             @BeforeEach         表示使用了该注解的方法应该在当前类中每一个使用了@Test、@RepeatedTest、
  //                                          @ParameterizedTest或者@TestFactory注解的方法之前 执行
  //  @After              @AfterEach          表示使用了该注解的方法应该在当前类中每一个使用了@Test、@RepeatedTest、
  //                                          @ParameterizedTest或者@TestFactory注解的方法之后执行
  //  @Ignore	          @Disabled	          用于禁用一个测试类或测试方法
  //  @Category           @Tag	              用于声明过滤测试的tags，该注解可以用在方法或类上；类似于TesgNG的测试组或JUnit 4的分类。
  //  @Parameters	      @ParameterizedTest  表示该方法是一个参数化测试
  //  @RunWith@ExtendWith @Runwith            就是放在测试类名之前，用来确定这个类怎么运行的
  //  @Rule               @ExtendWith	      Rule是一组实现了TestRule接口的共享类，提供了验证、监视TestCase和外部资源管理等能力
  //  @ClassRule	      @ExtendWith	      @ClassRule用于测试类中的静态变量，必须是TestRule接口的实例，且访问修饰符必须为public。

  @Test
  public void dlkjnwvcoieqw() {
    log.info("我是测试");
  }

  @Test
  @Explains("我是测试")
  public void dlknwfceow() {
    log.info("我是测试");
  }

  @Test
  @Disabled
  public void dslknviwuhjeu() {
    log.info("我是测试@Disabled");
  }

  @Test
  public void dslknvjdiwuhu() {
    try {
      Thread.sleep(RM.nextInt(1000 * 5));
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    log.info("我是测试@Disabled");
  }

  @Test
  public void dslknvjuhjeu() {
    try {
      Thread.sleep(RM.nextInt(1000 * 5));
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    log.info("我是测试@Disabled");
  }

  @Test
  public void dslknvwuhjeu() {
    log.info("我是测试@Disabled");
  }

  @Test
  public void dsvjdiwuhjeu() {
    try {
      Thread.sleep(RM.nextInt(1000 * 5));
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    log.info("我是测试@Disabled");
  }

  @Test
  @Explains("我是测试")
  public void sdaf3() {
    log.info("我是测试");
  }

  @Test
  @Disabled
  public void smnwodvwiu() {
    log.info("我是测试 @Disabled");
  }

  @Test
  @Tag("spojqwfowq tags")
  public void spojqwfowq() {
    log.info("我是测试  @Tag");
  }
}

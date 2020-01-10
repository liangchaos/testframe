package com.testframe.multiple.multiplepackage.packages;

import com.lch.enterpri.testframe.Explains;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Random;

/**
 * @program: EnterpriseSystem<br>
 * @author: LiangChao<br>
 * @description: 测试类<br>
 * @create: 2020-01-09 17:13
 */
@Log4j2
public class TestClassTwo {

  private static Random RM = new Random();

  @Test
  @Explains("我是测试")
  public void d23456() {
    Assertions.assertTrue(RM.nextBoolean());
  }

  @Test
  public void d23456res() {
    Assertions.assertTrue(RM.nextBoolean());
  }

  @Test
  public void dsnfvjdwse() {
    Assertions.assertTrue(RM.nextBoolean(), "false");
  }

  @Test
  @Explains("我是测试")
  public void dwfuew() {
    Assertions.assertTrue(RM.nextBoolean(), "true");
  }

  @Test
  public void dwsew() {
    Assertions.assertEquals(1, RM.nextInt());
  }

  @Test
  public void gfrew() {
    Assertions.assertEquals(RM.nextLong(), 1000L);
  }

  @Test
  @Explains("我是测试")
  public void sdiojvsd() {
    Assertions.assertEquals(RM.nextFloat(), 1f);
  }

  @Test
  @Explains("我是测试")
  public void w3e4r5t6() {
    Assertions.assertNotEquals(1, 1);
  }
}

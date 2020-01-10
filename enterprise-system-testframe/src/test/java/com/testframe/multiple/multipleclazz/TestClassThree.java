package com.testframe.multiple.multipleclazz;

import com.lch.enterpri.testframe.Explains;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Random;

/**
 * @program: EnterpriseSystem<br>
 * @author: LiangChao<br>
 * @description: 测试类<br>
 * @create: 2020-01-09 17:13
 */
@Log4j2
public class TestClassThree {

  private static Random RM = new Random();

  @Test
  @Explains("我是测试")
  public void lskjdf() {
    Assertions.assertTrue(RM.nextBoolean());
  }

  @Test
  public void qwert() {
    Assertions.assertFalse(RM.nextBoolean());
  }

  @Test
  @Explains("我是测试")
  public void s1234567() {
    Assertions.assertThrows(
        Exception.class,
        () -> {
          throw new Exception("测试异常:Exception");
        });
  }

  @Test
  @Explains("我是测试")
  public void w3e45ty() {
    Assertions.assertThrows(
        Exception.class,
        () -> {
          throw new IOException("测试异常:IOException");
        });
  }

  @Test
  public void wert() {
    Assertions.assertDoesNotThrow(
        () -> {
          throw new RuntimeException("500卢布");
        });
  }

  @Test
  public void x2345() {
    log.info("我是测试");
  }
}

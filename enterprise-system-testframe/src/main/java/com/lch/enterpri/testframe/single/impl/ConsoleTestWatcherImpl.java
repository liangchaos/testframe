package com.lch.enterpri.testframe.single.impl;

import com.lch.enterpri.testframe.single.AbstractTestReport;
import com.lch.enterpri.testframe.InfoEntity;
import com.lch.enterpri.testframe.TestEntity;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.AfterAll;
/** Description:控制台 Junit监控测试报告 User: Administrator-LiangChao Date: 2019-12-31 Time: 15:41 */
@Log4j2
public class ConsoleTestWatcherImpl extends AbstractTestReport {

  @AfterAll
  public static void afters() {
    for (InfoEntity entity : getInfoEntitiesList()) {
      log.info(entity);
    }
  }

  @Override
  public void print(TestEntity testEntity, Boolean isApple) {}
}

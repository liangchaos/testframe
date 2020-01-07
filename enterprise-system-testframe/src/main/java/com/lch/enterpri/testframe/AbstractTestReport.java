package com.lch.enterpri.testframe;

import com.lch.enterpri.util.DateTimeUtils;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtensionContext;

import java.lang.reflect.Method;
import java.util.Date;
import java.util.LinkedList;
import java.util.Optional;
/**
 * Description: TestWatcher抽象测试报告接口 <br>
 * User: Administrator-LiangChao <br>
 * Date: 2019-12-31 <br>
 * Time: 15:47
 */
@Log4j2
public abstract class AbstractTestReport implements TestReport {

  /** 执行数据集 * */
  private static LinkedList<InfoEntity> infoEntitiesList = new LinkedList<>();
  // 开始执行时间
  private static Date startDate;
  // 测试总开始时间
  private static Date testStartDate;
  // 执行对象
  private static TestReport testReport;

  // 测试统计数据信息
  private static Integer disabledSize = 0; // 禁用数量
  private static Integer failedSize = 0; // 失败数量
  private static Integer successfulSize = 0; // 成功数量
  private static Integer abortedSize = 0; // 终止数量

  @AfterAll
  public static void afters() {
    for (InfoEntity entity : infoEntitiesList) {
      log.info(entity);
    }
  }

  @BeforeAll
  public static void befores() {
    // 初始时间
    startDate = new Date();
    testStartDate = new Date();
  }

  public static Integer getAbortedSize() {
    return abortedSize;
  }

  public static Integer getDisabledSize() {
    return disabledSize;
  }

  public static Integer getFailedSize() {
    return failedSize;
  }

  /** 获取执行数据 * */
  public static LinkedList<InfoEntity> getInfoEntitiesList() {
    return infoEntitiesList;
  }

  public static Integer getSuccessfulSize() {
    return successfulSize;
  }

  /** 获取TestReport执行对象 */
  public static TestReport getTestReport() {
    return testReport;
  }

  /** 设置TestReport执行对象 * */
  public static void setTestReport(TestReport testReport) {
    AbstractTestReport.testReport = testReport;
  }

  /** 获取总执行时间 */
  public static Date getTotalTime() {
    Date date = new Date();
    date.setTime(new Date().getTime() - testStartDate.getTime());
    return date;
  }

  /** 添加执行数据信息 * */
  public void add(InfoEntity entity) {
    infoEntitiesList.add(entity);
  }

  @AfterEach
  @Override
  public void after() {}

  @BeforeEach
  @Override
  public void before() {
    startDate = new Date();
  }

  @Override
  public void testDisabled(ExtensionContext context, Optional<String> reason) {
    disabledSize++;

    this.add(
        new InfoEntity(
            getClazz(context),
            getMethod(context),
            getExplains(context),
            InfoEntity.ExecuteState.DISABLED,
            reason.get(),
            getRunTime(),
            getComplete(context)));
  }

  @Override
  public void testSuccessful(ExtensionContext context) {
    successfulSize++;

    this.add(
        new InfoEntity(
            getClazz(context),
            getMethod(context),
            getExplains(context),
            InfoEntity.ExecuteState.SUCCESSFUL,
            null,
            getRunTime(),
            getComplete(context)));
  }

  @Override
  public void testAborted(ExtensionContext context, Throwable cause) {
    abortedSize++;

    this.add(
        new InfoEntity(
            getClazz(context),
            getMethod(context),
            getExplains(context),
            InfoEntity.ExecuteState.ABORTED,
            cause.getMessage(),
            getRunTime(),
            getComplete(context)));
  }

  @Override
  public void testFailed(ExtensionContext context, Throwable cause) {
    failedSize++;

    this.add(
        new InfoEntity(
            getClazz(context),
            getMethod(context),
            getExplains(context),
            InfoEntity.ExecuteState.FAILED,
            cause.getMessage(),
            getRunTime(),
            getComplete(context)));
  }

  /** 获取测试类 */
  public String getClazz(ExtensionContext context) {
    return context.getRequiredTestClass().getName();
  }

  /**
   * 获取:类名.方法:说明注释
   *
   * @param context
   */
  public String getComplete(ExtensionContext context) {
    String str = context.getRequiredTestClass().getName();
    str += "." + context.getTestMethod().get().getName();

    Method method = context.getTestMethod().get();
    Explains explains = method.getAnnotation(Explains.class);
    str += (explains != null ? ":" + explains.value() : "");

    return str;
  }

  /**
   * 获取Explains
   *
   * @param context
   */
  public Explains getExplains(ExtensionContext context) {
    return context.getTestMethod().get().getAnnotation(Explains.class);
  }

  /** 获取测试方法名称 * */
  public String getMethod(ExtensionContext context) {
    return context.getTestMethod().get().getName();
  }

  /** 获取测试方法名称 * */
  public String getMethodExplains(ExtensionContext context) {
    Method method = context.getTestMethod().get();
    Explains explains = method.getAnnotation(Explains.class);
    return explains != null ? explains.value() : null;
  }

  /** 获取执行时间 */
  public String getRunTime() {
    return DateTimeUtils.TIME_COUNT_SSS.format(startDate, new Date());
  }
}

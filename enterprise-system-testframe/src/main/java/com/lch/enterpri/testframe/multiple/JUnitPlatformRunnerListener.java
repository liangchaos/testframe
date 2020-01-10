package com.lch.enterpri.testframe.multiple;

import com.lch.enterpri.testframe.Explains;
import com.lch.enterpri.testframe.InfoEntity;
import com.lch.enterpri.util.DateTimeUtils;
import lombok.extern.log4j.Log4j2;
import org.junit.platform.engine.TestExecutionResult;
import org.junit.platform.engine.TestSource;
import org.junit.platform.engine.reporting.ReportEntry;
import org.junit.platform.engine.support.descriptor.ClassSource;
import org.junit.platform.engine.support.descriptor.MethodSource;
import org.junit.platform.launcher.TestExecutionListener;
import org.junit.platform.launcher.TestIdentifier;
import org.junit.runner.Description;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunNotifier;

import java.lang.reflect.Method;
import java.util.Date;
import java.util.LinkedList;
import java.util.Optional;

import static org.junit.platform.engine.TestExecutionResult.Status.ABORTED;
import static org.junit.platform.engine.TestExecutionResult.Status.FAILED;

/**
 * Junit 运行环境监听
 *
 * @program: EnterpriseSystem<br>
 * @author: LiangChao<br>
 * @description: 来源于junit JUnitPlatformRunnerListener<br>
 * @create: 2020-01-09 16:43
 */
@Log4j2
public class JUnitPlatformRunnerListener implements TestExecutionListener {

  private static LinkedList<InfoEntity> infoEntityList = null;
  private final JUnitPlatformTestTree testTree;
  private final RunNotifier notifier;
  private Date startDate;

  /** 成功总数 */
  private Integer successfulSize = 0;
  /** 终止总数 */
  private Integer abortedSize = 0;
  /** 失败总数 */
  private Integer failedSize = 0;
  /** 禁用总数 */
  private Integer disabledSize = 0;

  public JUnitPlatformRunnerListener(JUnitPlatformTestTree testTree, RunNotifier notifier) {
    this.testTree = testTree;
    this.notifier = notifier;

    this.init();
  }

  /** 动态测试注册 */
  @Override
  public void dynamicTestRegistered(TestIdentifier testIdentifier) {
    log.debug("动态测试注册=>" + testIdentifier);

    String parentId = testIdentifier.getParentId().get();
    testTree.addDynamicDescription(testIdentifier, parentId);
  }

  /** 已跳过执行 */
  @Override
  public void executionSkipped(TestIdentifier testIdentifier, String reason) {
    log.debug("已跳过执行=>" + testIdentifier);

    if (testIdentifier.isTest()) {
      fireTestIgnored(testIdentifier);
    } else {
      testTree.getTestsInSubtree(testIdentifier).forEach(this::fireTestIgnored);
    }
  }

  /** 开始执行 */
  @Override
  public void executionStarted(TestIdentifier testIdentifier) {
    startDate = new Date();

    log.debug("开始执行=>" + testIdentifier);
    Description description = findJUnit4Description(testIdentifier);
    if (description.isTest()) {
      this.notifier.fireTestStarted(description);
    }
  }

  /** 执行完毕 */
  @Override
  public void executionFinished(
      TestIdentifier testIdentifier, TestExecutionResult testExecutionResult) {
    //    log.info("执行完毕=>" + testIdentifier);
    //    MethodSource source = (MethodSource) testIdentifier.getSource().get();
    //    log.info("<--请求处理类数据---------------------------------------------->");
    //    log.info("className:" + source.getClassName());
    //    log.info("methodName:" + source.getMethodName());
    //    log.info("methodParameterTypes:" + source.getMethodParameterTypes());
    //    log.info("<--执行结果数据------------------------------------------------>");
    //    log.info("执行结果:" + testExecutionResult.getStatus());
    //    log.info(
    //        "异常信息:"
    //            + (testExecutionResult.getThrowable() != null
    //                ? testExecutionResult.getThrowable().get().getMessage()
    //                : null));
    //    log.info("<--处理完成--------------------------------------------------->");

    Optional<TestSource> source = testIdentifier.getSource();
    if (!source.equals(Optional.empty())) {
      String className = null;
      String methodName = null;

      // 测试数据信息
      TestSource testSource = source.get();
      // 具体方法
      if (testSource instanceof MethodSource) {
        className = ((MethodSource) testSource).getClassName();
        methodName = ((MethodSource) testSource).getMethodName();

        // 添加数据
        infoEntityList.add(
            setInfoEntity(
                className,
                methodName,
                testExecutionResult.getStatus(),
                testExecutionResult.getThrowable()));
      }
      // 类
      else if (testSource instanceof ClassSource) {
        className = ((ClassSource) testSource).getClassName();
        methodName = null;
      }
    }

    // @DisplayName 注解
    Description description = findJUnit4Description(testIdentifier);
    TestExecutionResult.Status status = testExecutionResult.getStatus();
    if (status == ABORTED) {
      this.notifier.fireTestAssumptionFailed(toFailure(testExecutionResult, description));
    } else if (status == FAILED) {
      this.notifier.fireTestFailure(toFailure(testExecutionResult, description));
    }
    if (description.isTest()) {
      this.notifier.fireTestFinished(description);
    }
  }

  /** 报告 */
  @Override
  public void reportingEntryPublished(TestIdentifier testIdentifier, ReportEntry entry) {
    System.out.println("entry=>" + entry);
  }

  /** 查找JUnit4描述 */
  private Description findJUnit4Description(TestIdentifier testIdentifier) {
    return this.testTree.getDescription(testIdentifier);
  }

  /** 忽略测试 */
  private void fireTestIgnored(TestIdentifier testIdentifier) {
    Optional<TestSource> source = testIdentifier.getSource();
    if (!source.equals(Optional.empty())) {
      disabledSize++;

      TestSource testSource = source.get();
      if (testSource instanceof MethodSource) {
        // 添加忽略数据
        InfoEntity entity =
            setInfoEntity(
                ((MethodSource) testSource).getClassName(),
                ((MethodSource) testSource).getMethodName(),
                null,
                null);
        entity.setExecuteState(InfoEntity.ExecuteState.DISABLED);
        infoEntityList.add(entity);
      }
    }

    Description description = findJUnit4Description(testIdentifier);
    this.notifier.fireTestIgnored(description);
  }

  /** 终止数量 */
  public Integer getAbortedSize() {
    return abortedSize;
  }

  /** 禁用数量 */
  public Integer getDisabledSize() {
    return disabledSize;
  }

  /** 失败数量 */
  public Integer getFailedSize() {
    return failedSize;
  }

  /** 获取处理结果数据 */
  public LinkedList<InfoEntity> getInfoEntityList() {
    return infoEntityList;
  }

  /**
   * 获取类->方法注解
   *
   * @param clazz 要获取的测试类
   * @param method 测试类方法
   */
  public Explains getMethod(String clazz, String method) {
    if (clazz == null || method == null) {
      return null;
    }

    Explains explains = null;
    try {
      Class<?> classObject = Class.forName(clazz);
      for (Method methodTemp : classObject.getMethods()) {
        if (methodTemp.getName().equals(method)) {
          explains = methodTemp.getAnnotation(Explains.class);
          break;
        }
      }
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
    return explains;
  }

  /** 成功数量 */
  public Integer getSuccessfulSize() {
    return successfulSize;
  }

  /** 初始化 */
  private void init() {
    infoEntityList = new LinkedList<>();
  }

  /**
   * 设置测试数据信息
   *
   * @param className 类路径名称
   * @param methodName 方法名称
   * @param state 执行状态
   * @param throwable 执行产生异常简要信息
   */
  public InfoEntity setInfoEntity(
      String className,
      String methodName,
      TestExecutionResult.Status state,
      Optional<Throwable> throwable) {
    InfoEntity entity = new InfoEntity();

    // 类名
    entity.setClassName(className);
    // 方法
    entity.setMethodName(methodName);
    // 执行结果
    if (state != null) {
      if (state.equals(TestExecutionResult.Status.ABORTED)) {
        abortedSize++;
        entity.setExecuteState(InfoEntity.ExecuteState.ABORTED);
      } else if (state.equals(TestExecutionResult.Status.SUCCESSFUL)) {
        successfulSize++;
        entity.setExecuteState(InfoEntity.ExecuteState.SUCCESSFUL);
      } else if (state.equals(TestExecutionResult.Status.FAILED)) {
        failedSize++;
        entity.setExecuteState(InfoEntity.ExecuteState.FAILED);
      }
    }
    // 获取Explains
    entity.setExplains(this.getMethod(entity.getClassName(), entity.getMethodName()));
    // 备注
    if (throwable != null) {
      entity.setRemarks(
          (!throwable.equals(Optional.empty())) ? throwable.get().getMessage() : null);
    }
    // 执行时间
    Date date = new Date();
    date.setTime(new Date().getTime() - startDate.getTime());
    entity.setTime(DateTimeUtils.TIME_COUNT_SSS.formatDate(date));
    // 完整类方法
    entity.setComplete(
        entity.getClassName()
            + "."
            + entity.getMethodName()
            + (entity.getExplains() != null ? ":" + entity.getExplains().value() : ""));

    return entity;
  }

  /** 失败 */
  private Failure toFailure(TestExecutionResult testExecutionResult, Description description) {
    return new Failure(description, testExecutionResult.getThrowable().orElse(null));
  }
}

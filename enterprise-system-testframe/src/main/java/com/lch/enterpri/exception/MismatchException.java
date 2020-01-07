package com.lch.enterpri.exception;

/**
 * @program: EnterpriseSystem<br>
 * @author: LiangChao<br>
 * @description: 类型不匹配异常<br>
 * @create: 2020-01-05 00:27
 */
public class MismatchException extends RuntimeException {
  public MismatchException() {}

  public MismatchException(String message) {
    super(message);
  }

  public MismatchException(String message, Throwable cause) {
    super(message, cause);
  }

  public MismatchException(Throwable cause) {
    super(cause);
  }

  public MismatchException(
      String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}

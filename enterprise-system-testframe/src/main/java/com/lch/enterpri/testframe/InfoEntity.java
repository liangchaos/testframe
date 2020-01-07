package com.lch.enterpri.testframe;

import lombok.*;
/**
 * Description:数据记录信息 <br>
 * User: Administrator-LiangChao <br>
 * Date: 2019-12-31<br>
 * Time: 18:13
 */
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class InfoEntity {

  public String className;
  public String methodName;
  public Explains explains;
  public ExecuteState executeState; // 执行结果
  public String remarks; // 备注
  public String time; // 执行时间
  public String complete; // 完整说明 类名.方法:简要方法说明

  public enum ExecuteState {
    /** 禁用 * */
    DISABLED,
    /** 失败 * */
    FAILED,
    /** 成功 * */
    SUCCESSFUL,
    /** 终止 * */
    ABORTED;
  }
}

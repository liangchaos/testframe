package com.lch.enterpri.pdf;

import com.itextpdf.layout.Document;
import lombok.*;
/**
 * @program: EnterpriseSystem<br>
 * @author: LiangChao<br>
 * @description: PDF回调参数<br>
 * @create: 2020-01-05 20:42
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class PdfEntityParam {

  /** 文档对象 */
  private Document document;
  /** 文档区域宽度 */
  private float pageWidth;
}

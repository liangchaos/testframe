package com.lch.enterpri.pdf;

import com.itextpdf.kernel.pdf.PdfDocument;
/**
 * Description:测试生成PDF文件主题
 * User: Administrator-LiangChao
 * Date: 2020-01-01
 * Time: 13:21
 */
public interface PdfTestTheme {

    /*** 构建数据 */
    void build (PdfDocument pdf) throws Exception;

}

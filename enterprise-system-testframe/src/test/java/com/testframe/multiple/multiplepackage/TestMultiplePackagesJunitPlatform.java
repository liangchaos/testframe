package com.testframe.multiple.multiplepackage;

import com.lch.enterpri.testframe.TestFrameConfig;
import com.lch.enterpri.testframe.multiple.MultipleJunitPlatform;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.runner.RunWith;

/**
 * @program: EnterpriseSystem<br>
 * @author: LiangChao<br>
 * @description: 多类测试平台<br>
 * @create: 2020-01-09 15:11
 */
@RunWith(MultipleJunitPlatform.class)
@SelectPackages("com.testframe.multiple.multiplepackage.packages")
@TestFrameConfig(value = "classpath:/testframe.config.three.yml")
public class TestMultiplePackagesJunitPlatform {}

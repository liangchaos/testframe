## TestFrame  测试报告##

TestFrame  用于实现Junit5 生成测试报告.可对单个类执行测试报告,也可以对多个类执行测试报告数据生成.

### 单个类执行测试报告 ###
- #### 如何实现  ####
    ```java
    @ExtendWith(PDFTestWatcherImpl.class)
    public class TestMain extends PDFTestWatcherImpl {
    
      //生成报告设置自定义配置
      //public TestMain() {
      //  setUserConfig("classpath:/user-testframe.config.yml");
      //}
    	......
    }
    ```

- ####   执行效果 ####

    ![单个](https://github.com/liangchaos/testframe/blob/master/enterprise-system-testframe/doc/zip/TTEXT2020-01-10_163517640__1.jpg)
    ![单个](https://github.com/liangchaos/testframe/blob/master/enterprise-system-testframe/doc/zip/TTEXT2020-01-10_163517640__2.jpg)
    ![单个](https://github.com/liangchaos/testframe/blob/master/enterprise-system-testframe/doc/zip/TTEXT2020-01-10_163517640__3.jpg)
---

### 多个类执行测试报告###

- #### 如何实现 ####

  ```java
  @RunWith(MultipleJunitPlatform.class)
  @SelectClasses({
    TestClassOne.class,
    TestClassTwo.class,
    TestClassThree.class,
    TestClassFour.class,
    TestClassFive.class
  })
  @TestFrameConfig(value = "classpath:/testframe.config.two.yml")
  public class TestMultipleJunitPlatform {
  }
  ```

  

- #### 执行效果 ####

  - #### 效果一 ####

   ![单个](https://github.com/liangchaos/testframe/blob/master/enterprise-system-testframe/doc/zip/TTEXT2020-01-10_163528380__1.jpg)
   ![单个](https://github.com/liangchaos/testframe/blob/master/enterprise-system-testframe/doc/zip/TTEXT2020-01-10_163528380__2.jpg)

  - #### 效果二 ####
   ![单个](https://github.com/liangchaos/testframe/blob/master/enterprise-system-testframe/doc/zip/TTEXT2020-01-10_163531297__1.jpg)
   ![单个](https://github.com/liangchaos/testframe/blob/master/enterprise-system-testframe/doc/zip/TTEXT2020-01-10_163531297__2.jpg)










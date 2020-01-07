import com.lch.enterpri.testframe.Explains;
import com.lch.enterpri.testframe.impl.PDFTestWatcherImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.Random;

/**
 * Description:测试类<br>
 * User: Administrator-LiangChao <br>
 * Date: 2019-12-31 <br>
 * Time: 16:51
 */
@ExtendWith(PDFTestWatcherImpl.class)
public class TestMain extends PDFTestWatcherImpl {

  private static Random RM = new Random();

  public TestMain() {
    setUserConfig("classpath:/user-testframe.config.yml");
  }

  @Test
  public void asdfg() {
    Assertions.assertTrue(RM.nextBoolean());
  }

  @Test
  @DisplayName("测试说明")
  public void asdfgfds() {
    try {
      Thread.sleep(RM.nextInt(1000 * 5));
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  @Test
  public void asdfghgfds() {
    try {
      Thread.sleep(RM.nextInt(1000 * 5));
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  @Test
  public void asdfghgfr() {
    Assertions.assertTrue(RM.nextBoolean());
  }

  @Test
  public void asdfghjhgfd() {
    throw new RuntimeException("iText PdfPCell内容水平垂直居中 - 轩辕 - ITeye博客");
  }

  @Test
  public void asdftgyh() {
    Assertions.assertTrue(RM.nextBoolean());
  }

  @Test
  public void assertEquals() {
    Assertions.assertEquals(1, 2);
  }

  @Test
  public void assertFalse() {
    Assertions.assertTrue(false);
  }

  @Test
  public void assertNotEquals() {
    Assertions.assertNotEquals(new String(), null);
  }

  @Test
  public void assertNull() {
    Assertions.assertNull(null);
  }

  @Test
  public void assertTrue() {
    Assertions.assertTrue(true);
  }

  @Test
  public void awsertyuytre() {
    Assertions.assertTrue(RM.nextBoolean());
  }

  @Test
  public void bvcxz() {
    Assertions.assertTrue(RM.nextBoolean());
  }

  @Test
  public void gfdsa() {
    Assertions.assertTrue(RM.nextBoolean());
  }

  @Test
  public void hgfdsa() {
    Assertions.assertTrue(RM.nextBoolean());
  }

  @Test
  public void jmnhgfds() {
    Assertions.assertTrue(RM.nextBoolean());
  }

  @Test
  public void kjhgfrde() {
    Assertions.assertTrue(RM.nextBoolean());
  }

  @Test
  public void lkjhyu() {
    Assertions.assertTrue(RM.nextBoolean());
  }

  @Test
  public void lsdkjfg() {
    throw new NullPointerException(
        "\n"
            + "换一换搜索热点\n"
            + "1奥多姆戒指被拍卖\t901万\n"
            + "2梅西10年轰522球\t740万\n"
            + "3张艺兴肖战互关\t710万\n"
            + "4京张高铁今日开通\t700万\n"
            + "5林峯宣布结婚\t697万\n"
            + "6第一批90后5岁了\t688万\n"
            + "7重庆被砸女孩火化\t596万\n"
            + "8武汉Zara全部关闭\t540万\n"
            + "9电影总票房642亿新\t474万\n"
            + "查看更多>>\n");
  }

  @Test
  public void osdifug() {
    Assertions.assertTrue(RM.nextBoolean());
  }

  @Test
  public void qwertyuijhgfd() {
    try {
      Thread.sleep(RM.nextInt(1000 * 5));
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  @Test
  public void rjekw() {
    Assertions.assertTrue(RM.nextBoolean());
  }

  @Test
  public void sderftgy() {
    Assertions.assertTrue(RM.nextBoolean());
  }

  @Test
  public void sdfg() {
    throw new NullPointerException(
        "\n"
            + "换一换搜索热点\n"
            + "1奥多姆戒指被拍卖\t901万\n"
            + "2梅西10年轰522球\t740万\n"
            + "3张艺兴肖战互关\t710万\n"
            + "4京张高铁今日开通\t700万\n"
            + "5林峯宣布结婚\t697万\n"
            + "9电影总票房642亿新\t474万\n"
            + "102019亚洲小姐冠军\t394万\n"
            + "11俄乌续签输气协议\t374万\n"
            + "12尤文计划续约C罗\t342万\n"
            + "13埃及交通事故新\t321万\n"
            + "14罗永浩回应被解约\t57万\n"
            + "15网约车老板自杀\t297万\n"
            + "查看更多>>\n");
  }

  @Test
  public void sdfgfds() {
    Assertions.assertTrue(RM.nextBoolean());
  }

  @Test
  public void sdfgfdwqer() {
    Assertions.assertTrue(RM.nextBoolean());
  }

  @Test
  public void sdfghjhgfrew() {
    Assertions.assertTrue(RM.nextBoolean());
  }

  @Test
  public void soiduf() {
    throw new NullPointerException(
        "\n"
            + "3张艺兴肖战互关\t710万\n"
            + "4京张高铁今日开通\t700万\n"
            + "5林峯宣布结婚\t697万\n"
            + "6第一批90后5岁了\t688万\n"
            + "7重庆被砸女孩火化\t596万\n"
            + "8武汉Zara全部关闭\t540万\n"
            + "9电影总票房642亿新\t474万\n"
            + "102019亚洲小姐冠军\t394万\n"
            + "11俄乌续签输气协议\t374万\n"
            + "12尤文计划续约C罗\t342万\n"
            + "13埃及交通事故新\t321万\n"
            + "14罗永浩回应被解约\t57万\n"
            + "15网约车老板自杀\t297万\n"
            + "查看更多>>\n");
  }

  @Test
  @Explains(value = "测试ConsoleTestWatcherImpl实现")
  public void testConsoleTestWatcherImpl() {
    Assertions.assertTrue(RM.nextBoolean());
  }

  @Test
  @Explains(value = "ConsoleTestWatcherImpl")
  public void testConsoleTestWatcherImpl1() {
    Assertions.assertTrue(RM.nextBoolean());
  }

  @Test
  public void testConsoleTestWatcherImpl2() {
    Assertions.assertTrue(RM.nextBoolean());
  }

  @Test
  @Disabled
  public void testConsoleTestWatcherImpl3() {
    Assertions.assertTrue(RM.nextBoolean());
  }

  @Test
  public void testConsoleTestWatcherImpl4() {
    throw new RuntimeException("Error Test");
  }

  @Test
  public void uytrew() {
    Assertions.assertTrue(RM.nextBoolean());
  }

  @Test
  public void wert() {
    Assertions.assertTrue(RM.nextBoolean());
  }

  @Test
  public void wertrew() {
    try {
      Thread.sleep(RM.nextInt(1000 * 5));
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  @Test
  public void werty() {
    Assertions.assertTrue(RM.nextBoolean());
  }

  @Test
  public void wkejrth() {
    throw new NullPointerException(
        "\n"
            + "换一换搜索热点\n"
            + "1奥多姆戒指被拍卖\t901万\n"
            + "2梅西10年轰522球\t740万\n"
            + "3张艺兴肖战互关\t710万\n"
            + "4京张高铁今日开通\t700万\n"
            + "5林峯宣布结婚\t697万\n"
            + "6第一批90后5岁了\t688万\n"
            + "7重庆被砸女孩火化\t596万\n"
            + "8武汉Zara全部关闭\t540万\n"
            + "9电影总票房642亿新\t474万\n"
            + "102019亚洲小姐冠军\t394万\n"
            + "11俄乌续签输气协议\t374万\n"
            + "12尤文计划续约C罗\t342万\n"
            + "13埃及交通事故新\t321万\n"
            + "14罗永浩回应被解约\t57万\n"
            + "15网约车老板自杀\t297万\n"
            + "查看更多>>\n");
  }

  @Test
  public void wlekd() {
    Assertions.assertTrue(RM.nextBoolean());
  }

  @Test
  public void xcvbnmhgfds() {
    Assertions.assertTrue(RM.nextBoolean());
  }

  @Test
  public void zsdfxg() {
    try {
      Thread.sleep(RM.nextInt(1000 * 5));
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  @Test
  public void zxcvbgfdsa() {
    Assertions.assertTrue(RM.nextBoolean());
  }

  @Test
  public void zxcvbhgfdesw() {
    try {
      Thread.sleep(RM.nextInt(1000 * 5));
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  @Test
  public void zxcvbnm() {
    Assertions.assertEquals("DD", "BB");
  }

  @Test
  public void zxcvghjk() {
    Assertions.assertNotEquals("D", "F");
  }
}

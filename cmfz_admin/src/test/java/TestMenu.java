
import com.qyg.cmfz.dao.MenuDao;
import com.qyg.cmfz.entity.Menu;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @Description
 * @Author gege
 * @Time 2018/7/5  11:08
 */
public class TestMenu {
    @Test
    public void test1(){
        ApplicationContext acx = new ClassPathXmlApplicationContext("/applicationContext.xml");

        MenuDao menuDao = (MenuDao) acx.getBean("menuDao");
        List<Menu> menus = menuDao.selectAll();
        for (Menu menu : menus) {
            System.out.println(menu);
        }
    }
}

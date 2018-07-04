import com.qyg.cmfz.dao.ManagerDao;
import com.qyg.cmfz.entity.Manager;
import com.qyg.cmfz.service.ManagerService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by gege on 2018/7/4.
 */
public class TestManager {
    @Test
    public void login(){
        ApplicationContext acx = new ClassPathXmlApplicationContext("/applicationContext.xml");

        /*ManagerService service = (ManagerService) acx.getBean("managerServiceImpl");

        System.out.println(service.loginManager("admin","123456"));*/

        ManagerDao managerDao = (ManagerDao) acx.getBean("managerDao");
        Manager manager = managerDao.selectByName("李四");
        System.out.println(manager);
    }
}

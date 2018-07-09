import com.qyg.cmfz.dao.GuruDao;
import com.qyg.cmfz.dao.PictureDao;
import com.qyg.cmfz.entity.Guru;
import com.qyg.cmfz.entity.Picture;
import com.qyg.cmfz.service.GuruService;
import com.qyg.cmfz.serviceImpl.GuruServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by gege on 2018/7/4.
 */
public class TestGuru {
    @Test
    public void test1(){
        ApplicationContext acx = new ClassPathXmlApplicationContext("/applicationContext.xml");

        //GuruDao guruDao = (GuruDao) acx.getBean("guruDao");

        Guru guru=new Guru();
        guru.setMasterName("%智%");
        /*List<Guru> gurus = guruDao.selectMany(guru,0,2);
        for (Guru guru1 : gurus) {
            System.out.println(guru1);
        }*/

        GuruService gs = (GuruService) acx.getBean("guruServiceImpl");
        Map<String, Object> map = gs.queryManyGuru(guru, 1, 2);
        for (String s : map.keySet()) {
            System.out.println(map.get(s));
        }

       /* GuruService guruServiceImpl = (GuruService) acx.getBean("guruServiceImpl");

        Map<String, Object> stringObjectMap = guruServiceImpl.queryAll(0, 1);

        Set<String> set = stringObjectMap.keySet();

        for (String s : set) {
            System.out.println(s);
        }*/



    }
}

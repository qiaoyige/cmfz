import com.qyg.cmfz.dao.PictureDao;
import com.qyg.cmfz.entity.Picture;
import com.qyg.cmfz.service.PictureService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;
import java.util.List;

/**
 * Created by gege on 2018/7/4.
 */
public class TestPicture {
    @Test
    public void test1(){
        ApplicationContext acx = new ClassPathXmlApplicationContext("/applicationContext.xml");

        /*PictureDao pictureDao = (PictureDao) acx.getBean("pictureDao");

        List<Picture> pictures = pictureDao.selectAll();
        for (Picture picture : pictures) {
            System.out.println(picture);
        }*/
       /* PictureService pictureService = (PictureService) acx.getBean("pictureServiceImpl");

        List<Picture> pictures = pictureService.queryAll();
        for (Picture picture : pictures) {
            System.out.println(picture);
        }*/
        PictureDao pictureDao = (PictureDao) acx.getBean("pictureDao");
        Picture picture=new Picture("3","4",new Date(),"1","1");
        int i = pictureDao.insertPicture(picture);
        System.out.println(i);
    }
}

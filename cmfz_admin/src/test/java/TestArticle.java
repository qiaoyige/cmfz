import com.qyg.cmfz.dao.ArticleDao;
import com.qyg.cmfz.entity.Article;
import com.qyg.cmfz.entity.Guru;
import com.qyg.cmfz.service.GuruService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.util.Map;

/**
 * Created by gege on 2018/7/4.
 */
public class TestArticle {
    @Test
    public void test1(){
        ApplicationContext acx = new ClassPathXmlApplicationContext("/applicationContext.xml");

        ArticleDao articleDao = (ArticleDao) acx.getBean("articleDao");

        List<Article> articles = articleDao.selectAllArticle(1, 3);
        for (Article article : articles) {
            System.out.println(article);
        }

    }
}

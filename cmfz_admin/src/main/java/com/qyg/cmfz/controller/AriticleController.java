package com.qyg.cmfz.controller;

import com.qyg.cmfz.entity.Article;
import com.qyg.cmfz.entity.RichTextResult;
import com.qyg.cmfz.service.ArticleService;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

/**
 * @Description
 * @Author gege
 * @Time 2018/7/8  18:51
 */
@Controller
@RequestMapping("/article")
public class AriticleController {

    @Autowired
    private ArticleService articleService;
    private ArrayList<String> data = new ArrayList<String>();
    ;

    @RequestMapping("/addContent")
    public @ResponseBody
    RichTextResult addContent(@RequestParam("files") MultipartFile[] files, HttpServletRequest request) {

        RichTextResult result = new RichTextResult();

        try {
            String realPath = request.getRealPath("");
            String uploadPath = realPath.substring(0, realPath.lastIndexOf("\\")) + "\\upload";
            if (files != null && files.length != 0) {
                for (MultipartFile file : files) {

                    String fileName = UUID.randomUUID().toString().replace("-", "") + "." + FilenameUtils.getExtension(file.getOriginalFilename());
                    // 将上传的文件转存到服务器中存储
                    file.transferTo(new File(uploadPath + "\\" + fileName));

                    // 将上传的图片在服务器的url响应给客户端  图片回显
                    data.add(request.getContextPath() + "/upload/" + fileName);
                }
            }
            result.setErrno(0);
            result.setData(data);
        } catch (Exception e) {
            result.setErrno(1);
            e.printStackTrace();
        }
        return result;
    }

    @RequestMapping("/createArticle")
    public @ResponseBody
    String createArticle(Article article) {

        if (article.getArticleTitle()==null&&article.getIntroduction()==null){
            String id = UUID.randomUUID().toString().replace("-", "");
            Date date = new Date();
            article.setArticleId(id);
            article.setDate(date);
            if (article.getArticleStatus() == null) {
                article.setArticleStatus("下架");
            } else {
                article.setArticleStatus("上架");
            }
            article.setMainPic(data.toString());
            System.out.println(article);
            articleService.addArticle(article);
            return "添加成功";
        }else{
            return "添加失败";
        }
    }

}

package com.qyg.cmfz.controller;

import com.qyg.cmfz.entity.Picture;
import com.qyg.cmfz.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @Description
 * @Author gege
 * @Time 2018/7/5  20:17
 */
@Controller
@RequestMapping("/picture")
public class PictureController {

    @Autowired
    private PictureService pictureService;

    @RequestMapping("/showAllPicture")
    public @ResponseBody Map<String, Object> showAllPicture(Integer page,Integer rows){
        return pictureService.queryAll(page, rows);
    }

    @RequestMapping("/add")
    public @ResponseBody  String add(Picture picture, @RequestParam("myfile") MultipartFile myFile, HttpSession session) throws IOException {
        String id= UUID.randomUUID().toString().replace("-","");
        Date date=new Date();
        picture.setPictureId(id);
        picture.setPictureDate(date);

        String realPath=session.getServletContext().getRealPath("");
        if(!myFile.isEmpty()){
            int lastIndexOf = realPath.lastIndexOf("\\");

            String uploadPath = realPath.substring(0, lastIndexOf)+"/"+"upload";
            //获取文件名
            String originalFilename = myFile.getOriginalFilename();
            System.out.println(originalFilename);

            String uuidName=UUID.randomUUID().toString().replace("-","");

            //文件名后缀
            String fileName=originalFilename.substring(originalFilename.indexOf("."));

            String path=uploadPath+"/"+uuidName+fileName;

            myFile.transferTo(new File(path));

            picture.setPicturePath(uuidName+fileName);

            pictureService.addPicture(picture);
            return "上传成功";
       }else{
           return "上传失败";
       }
    }

    @RequestMapping("/update")
    public @ResponseBody  String update(Picture picture,@RequestParam("myfile") MultipartFile myFile,HttpSession session) throws IOException {
        if(picture.getPictureId().equals("")){
            return "请选择修改对象";
        }else{
            if(!myFile.isEmpty()){

                String realPath=session.getServletContext().getRealPath("");

                int lastIndexOf = realPath.lastIndexOf("\\");

                String uploadPath = realPath.substring(0, lastIndexOf)+"/"+"upload";

                String path=uploadPath+"/"+picture.getPicturePath();

                myFile.transferTo(new File(path));

            }
            picture.setPictureDate(new Date());
            pictureService.modifyPicture(picture);
            return "修改成功";
        }

    }
}

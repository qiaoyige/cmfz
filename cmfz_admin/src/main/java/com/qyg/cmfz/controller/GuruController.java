package com.qyg.cmfz.controller;

import cn.afterturn.easypoi.entity.vo.NormalExcelConstants;
import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import com.alibaba.fastjson.JSON;
import com.qyg.cmfz.entity.Guru;
import com.qyg.cmfz.service.GuruService;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @Description
 * @Author gege
 * @Time 2018/7/6  17:39
 */
@Controller
@RequestMapping("/guru")
public class GuruController {

    @Autowired
    private GuruService guruService;

    /*@RequestMapping("/showAllGuru")
    public @ResponseBody  Map<String,Object> showAllGuru(Integer page, Integer rows){
        return guruService.queryAll(page,rows);
    }*/
    @RequestMapping("/add")
    public @ResponseBody String add(Guru guru, @RequestParam("myfile") MultipartFile myFile, HttpSession session) throws IOException {

        String id= UUID.randomUUID().toString().replace("-","");
        guru.setMasterId(id);

        String realPath=session.getServletContext().getRealPath("");
        if(!myFile.isEmpty()){
            int lastIndexOf = realPath.lastIndexOf("\\");

            String uploadPath = realPath.substring(0, lastIndexOf)+"/"+"upload/guru";
            //获取文件名
            String originalFilename = myFile.getOriginalFilename();

            String uuidName=UUID.randomUUID().toString().replace("-","");

            //文件名后缀
            String fileName=originalFilename.substring(originalFilename.indexOf("."));

            String path=uploadPath+"/"+uuidName+fileName;

            myFile.transferTo(new File(path));

            guru.setMasterPhoto(uuidName+fileName);

            guruService.addGuru(guru);
            return "添加成功";
        }else{
            return "添加失败";
        }
    }

    @RequestMapping("/change")
    public @ResponseBody String change(Guru guru, @RequestParam("myfile") MultipartFile myFile, HttpSession session) throws IOException {

        if("".equals(guru.getMasterId())){
            return "请选择修改对象";
        }else{
            System.out.println("jinru");
            if(!myFile.isEmpty()){
                String realPath=session.getServletContext().getRealPath("");

                int lastIndexOf = realPath.lastIndexOf("\\");

                String uploadPath = realPath.substring(0, lastIndexOf)+"/"+"upload/guru";

                String path=uploadPath+"/"+guru.getMasterPhoto();

                myFile.transferTo(new File(path));

            }
            guruService.modifyGuru(guru);
            return "修改成功";
        }
    }


    @RequestMapping(value = "/showAllGuru",method = RequestMethod.POST)
    public @ResponseBody  Map<String,Object> showAllGuru(Guru guru,Integer page, Integer rows,String n,String value){
        System.out.println("n:"+n);
        System.out.println(value);
        if(n==null&&value==null){
            return guruService.queryAll(page,rows);
        }else{
            System.out.println(n);
            if(n.equals("name")){
               /* guru.setMasterName("%"+value+"%");*/
               guru.setMasterName(value);
            }else if(n.equals("des")){
                guru.setMasterSummary(value);
            }
            return guruService.queryManyGuru(guru,page,rows);
        }
    }

    @RequestMapping(value="/importExcel",method = RequestMethod.POST)
    @ResponseBody
    public String importExcel(@RequestParam("myfile") MultipartFile file,HttpServletRequest request) throws Exception{

        if(!file.isEmpty()) {
            ImportParams params = new ImportParams();

            //表格标题（默认为0） 但是如果设置标题，九设为一
            params.setTitleRows(0);
            //设置表头
            params.setHeadRows(1);

            //是否保存上传的Excel
            params.setNeedSave(true);

            String realPath = request.getSession().getServletContext().getRealPath("");
            int lastIndexOf = realPath.lastIndexOf("\\");

            String uploadPath = realPath.substring(0, lastIndexOf) + "/" + "upload/guru";

            //获取文件名
            String originalFilename = file.getOriginalFilename();

            String uuidName = UUID.randomUUID().toString().replace("-", "");

            //文件名后缀
            String fileName = originalFilename.substring(originalFilename.indexOf("."));

            String path = uploadPath + "/" + uuidName + fileName;
            File f = new File(path);

            file.transferTo(f);
            List<Guru> gurus = ExcelImportUtil.importExcel(f, Guru.class, params);
            System.out.println(gurus);

            /*String toJSONString = JSON.toJSONString(gurus);
            System.out.println(toJSONString);

            List<Guru> parse = (List<Guru>) JSON.parse(toJSONString);*/

            for (Guru guru : gurus) {
                String uuidId = UUID.randomUUID().toString().replace("-", "");
                guru.setMasterId(uuidId);
            }
            guruService.addMany(gurus);
            return "添加成功";
        }else{
            return "添加失败";
        }
    }

    @RequestMapping("/exportExcel")
    public void export(HttpServletResponse response) throws IOException {
        List<Guru> gurus = guruService.queryAlls();

        Workbook workbook = ExcelExportUtil.exportBigExcel(new ExportParams("上师信息", "上师信息表"), Guru.class, gurus);

        //输出流
        ServletOutputStream outputStream = response.getOutputStream();
        //导出文件，文件下载的方式

        String filename=new String("上师信息表.xls".getBytes(),"iso-8859-1");
        //文件下载，设置响应头
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("content-disposition","attachment;fileName="+filename);


        workbook.write(outputStream);
        outputStream.close();
        /*return NormalExcelConstants.JEECG_EXCEL_VIEW;*/
    }

    /**
    *@Description  创建文章的作者
    *@Author gege
    *@Time  2018/7/8 19:47
    *@Param []
    *@Exception
    *@Return java.util.List<com.qyg.cmfz.entity.Guru>
    */
    @RequestMapping("/articleAuthor")
    public @ResponseBody List<Guru> articleAuthor(){
        return guruService.queryAlls();
    }
}

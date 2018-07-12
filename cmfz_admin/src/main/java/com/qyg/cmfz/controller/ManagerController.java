package com.qyg.cmfz.controller;

import com.qyg.cmfz.entity.Manager;
import com.qyg.cmfz.service.ManagerService;
import com.qyg.cmfz.utils.CreateValidateCode;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * @Description Manager的控制器层
 * @Author gege
 * @Time 2018/7/4  16:36
 */
@Controller
@RequestMapping("/manager")
public class ManagerController {

    @Autowired
    private ManagerService managerService;

    /**
    *@Description
    *@Author gege
    *@Time  2018/7/4 21:00
    *@Param [name, request]
    *@Exception
    *@Return java.lang.String
    */
    @RequestMapping("/toLogin")
    public String toLogin(String name,HttpServletRequest request) throws UnsupportedEncodingException {
        name="";
        Cookie[] cookies = request.getCookies();
        if(cookies!=null){
            for (Cookie cookie : cookies) {
                    if(cookie.getName().equals("cookName")){
                        name=cookie.getValue();
                        name = URLDecoder.decode(name,"UTF-8");
                        request.setAttribute("name",name);
                    }
            }
        }
        return "login";

    }

    /**
    *@Description
    *@Author gege
    *@Time  2018/7/4 19:30
    *@Param [name, pwd, enCode, session, response, remenberName]
    *@Exception
    *@Return java.lang.String
    */
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public @ResponseBody String login(@RequestParam("mgrName") String name, @RequestParam("mgrPwd") String pwd, String enCode, HttpSession session, HttpServletResponse response, boolean rememberName) throws UnsupportedEncodingException {
        /*String message="";
        String vcode = (String) session.getAttribute("vcode");
        Manager manager = managerService.loginManager(name, pwd);

        if(enCode==null || enCode.isEmpty()|| !vcode.equalsIgnoreCase(enCode)){
           message="验证码错误";
        }else if(manager!=null){
            session.setAttribute("manager", manager);

            if(remenberName){
                String managerName=manager.getMgrName();
                String encode = URLEncoder.encode(managerName,"UTF-8");
                Cookie cookie =new Cookie("cookName",encode);

                cookie.setMaxAge(60*60*24*7);
                response.addCookie(cookie);
            }
           message="success";
        }else{
            message="账户或密码错误";
        }
        return message;*/

        String message="";
        // 在web环境中安全管理器会自动进行初始化
        String vcode = (String) session.getAttribute("vcode");
        if(enCode==null || enCode.isEmpty()|| !vcode.equalsIgnoreCase(enCode)){
            message="验证码错误";
        }else{
            Subject subject = SecurityUtils.getSubject();
            try {
                subject.login(new UsernamePasswordToken(name,pwd,rememberName));
                session.setAttribute("name",name);
                // 编程式授权
                System.out.println(subject.hasRole("root") ? "有root角色":"无root角色");
                message="success";
            } catch (UnknownAccountException e) {
                e.printStackTrace();
                message="账户不存在";
            } catch (IncorrectCredentialsException ice){
                ice.printStackTrace();
                message="密码不正确";
            } catch (AuthenticationException ae){
                ae.printStackTrace();
                return "redirect:/login.jsp";
            }
        }
        return message;
    }

    /**
    *@Description
    *@Author gege
    *@Time  2018/7/4 19:20
    *@Param [response, session]
    *@Exception
    *@Return void
    */
    @RequestMapping("/validate")
    public void Validate(HttpServletResponse response, HttpSession session) throws IOException{

        CreateValidateCode va=new CreateValidateCode(150, 30, 4);

        String vcode=va.getCode();

       session.setAttribute("vcode",vcode);

        va.write(response.getOutputStream());

    }
    @RequestMapping("/exit")
    public String  exit(HttpSession session){

        session.removeAttribute("manager");

        return "login";
    }

}

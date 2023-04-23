package personal.xjl.jerrymouse.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import personal.xjl.jerrymouse.entity.Admin;
import personal.xjl.jerrymouse.service.AdminServiceImpl;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

//注解，定义该类是控制器，spring在扫描后会自动生成一个bean的对象，他的名字是adminController
@Controller
//如何访问控制器，像servlet的url_pattern
@RequestMapping("/Admin")
@Api(value = "this is a  admin api",tags = "admins api")
public class AdminController {
    //自動注入，業務層對象
    @Autowired
    AdminServiceImpl adminServiceImpl;
    //select,list,分层的请求形式
    @RequestMapping("list.do")
    //响应给用户的是html中的body部分
//    @ResponseBody
    @ApiOperation(value = "listAdmins",notes = "list methods,显示管理员",tags="list Admins")
    public String list(Model model){
        List<Admin> admins=adminServiceImpl.findAllAdmins();
        model.addAttribute("admins",admins);
        return "listAdmins";
    }
    //add,转向到addAdmin.html页面
    @RequestMapping("toAdd.do")
    public String toAdd(Model model){

        return "addAdmin";
    }
    //update
    //delete
    //login
    @RequestMapping(value = "login.do",method = RequestMethod.POST)
//    @ResponseBody
    public String login(String username, @RequestParam("password") String password, String freeLogin, HttpServletResponse res, Model model){
        if(adminServiceImpl.login(username,password)){
            //如果用户勾选了“七天免登录”，创建cookie
            if (freeLogin != null){
                Cookie username_cookie=new Cookie("username",username);
                username_cookie.setMaxAge(7*24*60*60);
                Cookie password_cookie=new Cookie("password",password);
                res.addCookie(username_cookie);
                res.addCookie(password_cookie);
            }
            return list(model);
        }
        else
            return "login";
    }
    @RequestMapping("getPage.do")
    public String getPage(String page){
        return page;
    }
    @RequestMapping("add.do")
    public String add(Admin admin, Model model, HttpSession session){
        adminServiceImpl.addAdmin(admin);
        System.out.println(session.getId());
        session.setAttribute("username",admin.getName());
        //调用list方法
        return list(model);
    }
}

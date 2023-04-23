package personal.xjl.jerrymouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import personal.xjl.jerrymouse.service.AdminServiceImpl;
import personal.xjl.jerrymouse.service.StudentServiceImpl;
import personal.xjl.jerrymouse.service.TeacherServiceImpl;
import javax.servlet.http.HttpSession;

@Controller
//定义该控制器的访问形式

public class LoginController {
    @Autowired
    StudentServiceImpl studentService;
    @Autowired
    TeacherServiceImpl teacherService;
    @Autowired
    AdminServiceImpl adminService;
    //login.html
    @RequestMapping("login.html")
    public String login(){
        return "login";
    }
    //Login.do
    @RequestMapping("Login.do")
    public String login(String username, String password, int Type, HttpSession session) {
        switch (Type){
            case 1:
                //调用studentService.login方法，true则list，false则停留在登录页面
                if (studentService.login(username,password)){
                    session.setAttribute("username",username);
                    return "main";
                }
                else{
                    return "login";
                }
            case 2:
                if (teacherService.login(username,password)){
                    session.setAttribute("username",username);
                    return "main";
                }
                else{
                    return "login";
                }
            case 3:
                if (adminService.login(username,password)){
                    session.setAttribute("username",username);
                    return "main";
                }
                else{
                    return "login";
                }
        }
        return "login";
    }
}

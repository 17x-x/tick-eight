package personal.xjl.jerrymouse.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import personal.xjl.jerrymouse.entity.Student;
import personal.xjl.jerrymouse.service.StudentServiceImpl;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

//注解，定义该类是控制器，spring在扫描后会自动生成一个bean的对象，他的名字是studentController
@Controller
//如何访问控制器，像servlet的url_pattern
@RequestMapping("/Student")
@Api(value = "this is a  student api",tags = "students api")
public class StudentController {
    //创建日志对象
    private final Log log= (Log) LogFactory.getLog(StudentController.class);
    //自動注入，業務層對象
    @Autowired
    StudentServiceImpl studentServiceImpl;
//    StudentMapper studentMapper;
    //select,list,分层的请求形式
    @RequestMapping("list.do")
    //响应给用户的是html中的body部分
//    @ResponseBody
    @ApiOperation(value = "listStudents",notes = "list methods,显示学生",tags="list Students")
    public String list(Model model,@RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "5") Integer pageSize){
//        log.info("this is my info log");
//        log.error("this is my error log");
        //定义数据分页的起始页
        PageHelper.startPage(pageNum,pageSize);
        //获取数据库里Student表的所有数据
        List<Student>students= studentServiceImpl.findAllStudents();
        PageInfo pageInfo=new PageInfo<Student>(students,5);
        model.addAttribute("students",students);
        model.addAttribute("pageInfo",pageInfo);
        //返回字符串list students给用户
        return "listStudents";
    }
    //add,转向到addStudent.html页面
    @RequestMapping("toAdd.do")
    public String toAdd(Model model){
//        List<Product> students=new ArrayList<>();
//        for (int i=1;i<=10;i++)
//        {
//            students.add(new Product("product"+i,i,i));
//        }
//        model.addAttribute("students",students);
        //传出数据，名字username,值是apolo
//        model.addAttribute("username","apolo");
//        model.addAttribute("pwd","123");
        return "addStudent";
    }
    //toUpdate,通过主键查找原数据，渲染updateStudent.html页面
    @RequestMapping("toUpdate.do")
    public String toUpdate(int id,Model model){
        Student student=studentServiceImpl.findStudent(id);
        model.addAttribute("student",student);
        return "updateStudent";
    }

    @RequestMapping("update.do")
    //update，更新数据到数据库，回到main.html
    public String update(Student newStudent){
        studentServiceImpl.modifyStudent(newStudent);
        return "main";
    }

    //delete
    //login
    @RequestMapping(value = "login.do",method = RequestMethod.POST)
//    @ResponseBody
    public String login(String username, @RequestParam("password") String password, String freeLogin, HttpServletResponse res,Model model){
        if(studentServiceImpl.login(username,password)){
            //如果用户勾选了“七天免登录”，创建cookie
            if (freeLogin != null){
                Cookie username_cookie=new Cookie("username",username);
                username_cookie.setMaxAge(7*24*60*60);
                Cookie password_cookie=new Cookie("password",password);
                res.addCookie(username_cookie);
                res.addCookie(password_cookie);
            }
            return "main";
        }
        else
            return "login";
        //设置session变量，用于登录拦截器取值
//        session.setAttribute("username",username);
//        return "welcome you!"+username+",your password is  "+password;
    }
    @RequestMapping("getPage.do")
    public String getPage(String page){
        return page;
    }
    @RequestMapping("add.do")
    public String add(Student student,HttpSession session){
        studentServiceImpl.addStudent(student);
        System.out.println(session.getId());
        session.setAttribute("username",student.getName());
        //调用list方法
        return "main";
    }
    //delete.do
    @RequestMapping("delete.do")
    public String delete(int id){
        studentServiceImpl.removeStudent(id);
        return "main";
    }
    //logout.do
    @RequestMapping("logout.do")
    public String logout(HttpSession session){
        session.setAttribute("username",null);
        return "main";
    }
}

package personal.xjl.jerrymouse.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import personal.xjl.jerrymouse.entity.Course;
import personal.xjl.jerrymouse.entity.Student;
import personal.xjl.jerrymouse.entity.Teacher;
import personal.xjl.jerrymouse.service.CourseServiceImpl;
import personal.xjl.jerrymouse.service.TeacherServiceImpl;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Locale;

//注解，定义该类是控制器
@Controller
//如何访问控制器，像servlet的url_pattern
@RequestMapping("/Teacher")
@Api(value = "this is a  teacher api",tags = "teachers api")
public class TeacherController {
    //自動注入，業務層對象
    @Autowired
    TeacherServiceImpl teacherServiceImpl;
    //select,list,分层的请求形式
    @RequestMapping("list.do")
    //响应给用户的是html中的body部分
//    @ResponseBody
    @ApiOperation(value = "listTeachers",notes = "list methods,显示教师",tags="list Teachers")
    public String list(Model model,@RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "5") Integer pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<Teacher>teachers= teacherServiceImpl.findAllTeachers();
        PageInfo pageInfo=new PageInfo<Teacher>(teachers,5);
        model.addAttribute("teachers",teachers);
        model.addAttribute("pageInfo",pageInfo);
        List<Course> courses= teacherServiceImpl.findAllCourse();
        model.addAttribute("courses",courses);
        //返回字符串list teachers给用户
        return "listTeachers";
    }
    @Autowired
    private MessageSource messageSource;

    @RequestMapping("toUpdate.do")
    public String toUpdate(int id,Model model){
        Teacher teacher=teacherServiceImpl.findTeacher(id);
        model.addAttribute("teacher",teacher);
        List<Course> courseList= teacherServiceImpl.findAllCourse();
        model.addAttribute("courses",courseList);
        return "updateTeacher";
    }
    @RequestMapping("update.do")
    //update，更新数据到数据库，回到main.html
    public String update(Teacher newTeacher){
        teacherServiceImpl.modifyTeacher(newTeacher);
        return "main";
    }
    //add,转向到addTeacher.html页面
    @RequestMapping("toAdd.do")
    public String toAdd(Model model){
        //model模式对象用于传出数据
//        List numberList = new ArrayList();
//        for (int i=1;i<3;i++){
//            numberList.add(i);
//        }

//        List<Student> students = new ArrayList<>();
//        students.add(new Student("张三","123",18,"1班"));
//        students.add(new Student("李四","321",19,"2班"));
//        students.add(new Student("王五","132",17,"3班"));
//        model.addAttribute("students",students);

        Locale locale = LocaleContextHolder.getLocale();
        model.addAttribute("Id", messageSource.getMessage("Id", null, locale));
        model.addAttribute("name", messageSource.getMessage("name", null, locale));
        model.addAttribute("password", messageSource.getMessage("password", null, locale));
        model.addAttribute("sex", messageSource.getMessage("sex", null, locale));
        model.addAttribute("birthday", messageSource.getMessage("birthday", null, locale));
        model.addAttribute("course_id", messageSource.getMessage("course_id", null, locale));
        model.addAttribute("professional", messageSource.getMessage("professional", null, locale));

        List<Course> courseList= teacherServiceImpl.findAllCourse();
        model.addAttribute("courses",courseList);
//        model.addAttribute("username","Tom");
        return "addTeacher";
    }


    //实体对象属性值的传入

//    public String add(@RequestParam("file") MultipartFile file, Teacher teacher, HttpSession session, Model model) throws IOException {

        //上传文件
//        uploadFile(file);
        //第二种
//       List<Teacher> teacherList = (List<Teacher>) session.getAttribute("teachers");
//        if(teacherList==null){
//            teacherList=new ArrayList<>();
//       }
//        teacherList.add(teacher);
//        session.setAttribute("teachers",teacherList);



//        teachers.add(new Teacher(01,"张三","数据库"));
//        teachers.add(new Teacher(02,"李四","数学"));
//        teachers.add(new Teacher(03,"王五","Java"));
//        model.addAttribute("teachers",teacher);
//        return "listTeachers";

//    private void uploadFile(MultipartFile file) throws IOException {
//        if (file!=null){
//            //在服务器上创建新文件:application.yml,spring.servlet.multiparFile.location+原文件名
//            File imageFile=new File(file.getOriginalFilename());
//            file.transferTo(imageFile);
//        }
//    }
    //update
    //delete
    //login
    @RequestMapping(value = "login.do",method = RequestMethod.POST)
//    @ResponseBody
    public String login(String username, @RequestParam("password") String password, String freeLogin, HttpServletResponse res, HttpSession session,Model model){
        if(teacherServiceImpl.login(username,password)){
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
//        return "welcome you!"+username+",你的密码是:"+password;
    }

    //delete.do
    @RequestMapping("delete.do")
    public String delete(int id){
        teacherServiceImpl.removeTeacher(id);
        return "main";
    }

    //万能进入页面
    @RequestMapping("getPage.do")
    public String getPage(String page){
        return page;
    }
    @RequestMapping("add.do")
    public String add(Teacher teacher, Model model, HttpSession session){
        teacherServiceImpl.addTeacher(teacher);
        System.out.println(session.getId());
        session.setAttribute("username",teacher.getName());
        //调用list方法
        return "main";
    }
}
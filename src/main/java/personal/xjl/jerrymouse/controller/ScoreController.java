package personal.xjl.jerrymouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import personal.xjl.jerrymouse.entity.Course;
import personal.xjl.jerrymouse.entity.Score;
import personal.xjl.jerrymouse.entity.Student;
import personal.xjl.jerrymouse.service.CourseServiceImpl;
import personal.xjl.jerrymouse.service.ScoreServiceImpl;
import personal.xjl.jerrymouse.service.StudentServiceImpl;


import java.util.List;

@Controller
@RequestMapping("/Score")
public class ScoreController {
    @Autowired
    ScoreServiceImpl scoreServiceImpl;
    @Autowired
    CourseServiceImpl courseServiceImpl;
    @Autowired
    StudentServiceImpl studentServiceImpl;
    //toGrade,准备评分
    @RequestMapping("toGrade.do")
    public String toGrade(Model model){
        List<Course> courses=courseServiceImpl.findAllCourses();
        List<Student>  students=studentServiceImpl.findAllStudents();
        model.addAttribute("courses",courses);
        model.addAttribute("students",students);
        return "grade";
    }
    //grade，评分
    @RequestMapping("grade.do")
    public String grade(Score score){
        scoreServiceImpl.grade(score);
        return "404";
    }
}

package personal.xjl.jerrymouse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import personal.xjl.jerrymouse.entity.Course;
import personal.xjl.jerrymouse.entity.Student;
import personal.xjl.jerrymouse.entity.Teacher;
import personal.xjl.jerrymouse.mapper.CourseMapper;
import personal.xjl.jerrymouse.mapper.TeacherMapper;

import java.util.List;

@Service
public class TeacherServiceImpl {
    @Autowired
    TeacherMapper teacherMapper;
    //顯示所有教师
    public List<Teacher> findAllTeachers(){
        return teacherMapper.queryAll();
    }
    //新增教师
    public void addTeacher(Teacher teacher){
        teacherMapper.insert(teacher);
    }
    @Autowired
    CourseMapper courseMapper;
    public List<Course> findAllCourse(){
        return courseMapper.queryAll();
    }
    //login
    public boolean login(String username, String password) {
        List<Teacher> teachers=teacherMapper.selectByNameAndPassword(username,password);
        if(teachers.size()==0)
            return false;
        else
            return  true;
    }

    public void removeTeacher(int id) {
        teacherMapper.deleteByPrimaryKey(id);
    }
    public Teacher findTeacher(int id) {
        return teacherMapper.selectByPrimaryKey(id);
    }

    public void modifyTeacher(Teacher newTeacher) {
        teacherMapper.updateByPrimaryKey(newTeacher);
    }
}

package personal.xjl.jerrymouse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import personal.xjl.jerrymouse.entity.Course;
import personal.xjl.jerrymouse.mapper.CourseMapper;

import java.util.List;

@Service
public class CourseServiceImpl {
    @Autowired
    CourseMapper courseMapper;
    public List<Course> findAllCourses(){
        return  courseMapper.queryAll();
    }


}

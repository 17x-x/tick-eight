package personal.xjl.jerrymouse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import personal.xjl.jerrymouse.entity.Student;
import personal.xjl.jerrymouse.mapper.StudentMapper;

import java.util.List;
//業務層的作用，支持多個相關聯的數據庫操作
//springboot啟動時自動掃描這個包生成一個service對象“StudentServiceImpl”
@Service
public class StudentServiceImpl {
    @Autowired
    StudentMapper studentMapper;
    //顯示所有學生
    public List<Student> findAllStudents(){
        return studentMapper.queryAll();
    }
    //新增學生
    public void addStudent(Student student){
        studentMapper.insert(student);
    }

    public boolean login(String username, String password) {
        List<Student> students=studentMapper.selectByNameAndPassword(username,password);
        if(students.size()==0)
            return false;
        else
            return  true;
    }

    public void removeStudent(int id) {
        studentMapper.deleteByPrimaryKey(id);
    }

    public Student findStudent(int id) {
        return studentMapper.selectByPrimaryKey(id);
    }

    public void modifyStudent(Student newStudent) {
        studentMapper.updateByPrimaryKey(newStudent);
    }
}

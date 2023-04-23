package personal.xjl.jerrymouse;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import personal.xjl.jerrymouse.spring.*;

@SpringBootTest
class JerrymouseApplicationTests {


    //自动注入对象，装配
    @Autowired
//    StudentMapper studentMapper;
    @Qualifier("myBenz")
    Car c1;
    @Autowired
    @Qualifier("myNMWC")
    CowCar cc1;
//    @Autowired
//    Human h1;
    @Test
    void contextLoads() {
        System.out.println(c1);
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("beans.xml");
        Car c2=(Car) applicationContext.getBean("myBWM");
        Car c3=(Car) applicationContext.getBean("myBYD");
        Car c4=(Car) applicationContext.getBean("myNissan");
        System.out.println(c2);
        System.out.println(c3);
        System.out.println(c4);
//        h1.introduce();
        Human h2=(Human) applicationContext.getBean("lisi");
        Human h3=(Human) applicationContext.getBean("wangwu");
        h2.introduce();
        h3.introduce();
        System.out.println(cc1);
        Cow c5=(Cow) applicationContext.getBean("myNMW");
        CowCar cc2=(CowCar) applicationContext.getBean("myNMWC");
        System.out.println(c5);
        System.out.println(cc2);
        ApplicationContext applicationContext1=new ClassPathXmlApplicationContext("aop.xml");
        MyMath myMath=(MyMath) applicationContext1.getBean("target");
        myMath.setN1(3);
        myMath.setN2(5);
        myMath.add();
        myMath.subtract();
        myMath.mul();
        myMath.dev();
    }
//    @Test
//    void toTest(){
//        Student student=new Student();
//        student.setName("tom");
//        student.setPassword("123456");
//        student.setSex(1);
//        student.setClazz("21java1");
//        studentMapper.insert(student);
//        studentMapper.delete(student);
//        List<Student> students=studentMapper.queryAll();
//        students.forEach(e-> System.out.println(e));
//    }


}

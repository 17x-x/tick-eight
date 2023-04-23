package personal.xjl.jerrymouse.spring;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component("target")
@Data
public class MyMath {
    private  int n1,n2,result;
    public void add(){
        result=n1+n2;
        System.out.println(result);
    }
    public void subtract(){
        result=n1-n2;
        System.out.println(result);
    }
    public void mul(){
        result=n1*n2;
        System.out.println(result);
    }
    public void dev(){
        result=n1/n2;
        System.out.println(result);
    }
    public void printResult(){
        System.out.println(result);
    }
}

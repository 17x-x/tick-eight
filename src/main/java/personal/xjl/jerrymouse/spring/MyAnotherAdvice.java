package personal.xjl.jerrymouse.spring;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component("myAdvice")
@Aspect
public class MyAnotherAdvice {
    @AfterReturning("execution(* personal.xjl.jerrymouse.spring.MyMath.add(..))")
    public void afterReturning() throws Throwable {
        System.out.println("---------这是后置增强--------");
    }

    @Before("execution(* personal.xjl.jerrymouse.spring.MyMath.subtract(..))")
    public void before() throws Throwable {
        System.out.println("---------这是前置增强----------");
    }
    @Around("execution(* personal.xjl.jerrymouse.spring.MyMath.dev(..))")
    public Object invoke(ProceedingJoinPoint jp) throws Throwable {
        System.out.println("---------around advice begin-----------");
        Object object=jp.proceed();
        System.out.println("----------around advice  end------");
        return object;
    }

}



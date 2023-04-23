package personal.xjl.jerrymouse.spring;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

//前置增强&后置增强
public class MyAdvice  implements MethodBeforeAdvice, AfterReturningAdvice, MethodInterceptor {
    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("----------前置增强----------");
    }

    @Override
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
        System.out.println("----------后置增强----------");
    }

    public Object invoke(MethodInvocation invocation) throws Throwable {
        System.out.println("----------环绕增强开始----------");
        Object object=invocation.proceed();
        System.out.println("----------环绕增强结束----------");
        return object;
    }

}

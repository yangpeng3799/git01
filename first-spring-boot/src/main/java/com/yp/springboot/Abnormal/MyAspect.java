package com.yp.springboot.Abnormal;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Component
@Aspect
public class MyAspect {

    @Pointcut("execution(* com.yp.springboot..Target.save(*))")
    public void test() {
    }

    @Before("test()")
    public void dobefore() {
    }

    //前置通知
    @Before("execution(* com.yp.springboot..Target.save(*))")
    public void doBefore(JoinPoint jp) {
        ServletRequestAttributes se = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        //url
        HttpServletRequest request = se.getRequest();
        //mothod
        String method = request.getMethod();
        //ip
        String remoteAddr = request.getRemoteAddr();
        //类，方法
        String declaringTypeName = jp.getSignature().getDeclaringTypeName();
        String name = jp.getSignature().getName();

        Object[] args = jp.getArgs();
        System.out.println("获取传递目标方法的参数" + jp.getArgs()[0]);
        System.out.println("获取传递目标方法的java对象" + jp.getSignature());
        System.out.println("获取传递目标对象" + jp.getTarget());
    }

    //后置通知
    @AfterReturning(pointcut = "execution(* com.yp.springboot..Target.save(*))", returning = "obj")
    public void doafter(JoinPoint jp, Object obj) {
        System.out.println("返回值" + obj.toString());
    }


    //异常通知
    @AfterThrowing(pointcut = "execution(* com.yp.springboot..Target.save(*))", throwing = "e")
    public void exception(JoinPoint jp, Throwable e) {
        System.out.println("目标组件出现已成" + e.getMessage());
    }


    //最终通知
    @After(value = "execution(* com.yp.springboot..Target.save(*))")
    public void fin() {
        System.out.println("最终通知正常方法结束 或者 异常通知之前");
    }

    //环绕通知
    // @Around("execution(* com.yp.Target.save(*))")
    public void Arround(ProceedingJoinPoint pj) {
        System.out.println("前置通知");
        try {
            Object obj = pj.proceed();
            System.out.println("后置通知 返回值:" + obj);
        } catch (Throwable e) {
            System.out.println("异常通知");
        }
        System.out.println("此处为最终通知");

    }

}

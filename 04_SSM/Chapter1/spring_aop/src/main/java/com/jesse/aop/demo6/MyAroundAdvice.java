package com.jesse.aop.demo6;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;


public class MyAroundAdvice implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        System.out.println("环绕前增强");

        Object obj = methodInvocation.proceed();

        System.out.println("环绕后增强");
        return null;
    }
}

package com.example.aopexample;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class AopLogger {

    @Before("execution(* com.example.aopexample.*Service.*(..))")
    public void logParameters(JoinPoint joinPoint) {
        log.trace("Called method {} with args {}", joinPoint.getSignature(), joinPoint.getArgs());
    }

    @AfterReturning(pointcut = "execution(* com.example.aopexample.*Service.*(..))", returning = "result")
    public void logResult(JoinPoint joinPoint, Object result) {
        log.trace("Return from method {} with {}", joinPoint.getSignature(), result);
    }

    @AfterThrowing(pointcut = "execution(* com.example.aopexample.*Service.*(..))", throwing = "ex")
    public void logException(JoinPoint joinPoint, Exception ex) {
        log.trace("Throwing from method {} exception {}", joinPoint.getSignature(), ex.getMessage());
    }
}

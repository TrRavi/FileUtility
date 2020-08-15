package com.example.fileupload.aoplog;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class SystemLog {

    @After("execution(* com.example.fileupload.controller..*(..)) ")
    public void doStuffBeforeThing(JoinPoint joinPoint) {
        StringBuilder logString = new StringBuilder();
        Class clazz = joinPoint.getTarget().getClass();
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        logString.append("\nHttp Request Details are:-");
        logString.append("\nUrl:- "+request.getRequestURL());
        logString.append("\nHttp method:- "+request.getMethod());
        logString.append("\nIp Address:- "+request.getRemoteAddr());
        Logger logger = LoggerFactory.getLogger(clazz);
        logger.info(logString.toString());
    }
}

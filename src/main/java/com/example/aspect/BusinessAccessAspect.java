package com.example.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class BusinessAccessAspect {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Before("com.example.aspect.CommonJoinPoint.businessLayerExecution()")
    public void before(JoinPoint joinPoint){
        //Advice
        logger.info(" Check for business access ");
        logger.info(" Allowed execution for {}", joinPoint);
    }
}
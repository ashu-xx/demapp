package com.example.aspect;

import org.aspectj.lang.annotation.Pointcut;

public class CommonJoinPoint {
    @Pointcut("execution(* com.example.data.*.*(..))")
    public void dataLayerExecution(){}

    @Pointcut("execution(* com.example.service.*.*(..))")
    public void businessLayerExecution(){}

    @Pointcut("dataLayerExecution() && businessLayerExecution()")
    public void allLayerExecution(){}

    @Pointcut("@annotation(com.example.aspect.TrackTime)")
    public void trackTimeAnnotation(){}

}
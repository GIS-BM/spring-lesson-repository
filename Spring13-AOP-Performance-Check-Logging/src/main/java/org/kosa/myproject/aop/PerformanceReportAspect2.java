package org.kosa.myproject.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

// @Aspect // AOP 담당 클래스임을 알림
// @Component // Bean으로 생성, 관리됨을 알림
public class PerformanceReportAspect2 {
  private static final Logger logger = LoggerFactory.getLogger(PerformanceReportAspect2.class);

  // [] 실행시 걸리는 시간 재는 메서드 checkTimeLogging 구현
  // 공통 기능이므로 횡단 관심사 로직에 해당된다.
  @Around("execution(public * org.kosa.myproject.model..*Service.*(..))")
  public Object checkTimeLogging(ProceedingJoinPoint joinPoint) throws Throwable {
    long startTime = System.currentTimeMillis();
    
    Object result = null;
    try {
      result = joinPoint.proceed(); // 핵심 비즈니스 로직 실행
    } finally {
      long endTime = System.currentTimeMillis();
      long duration = endTime - startTime;
      
      String className = joinPoint.getTarget().getClass().getSimpleName();
      String methodName = joinPoint.getSignature().getName();
      String logMessage = String.format("Class: %s, Method: %s, Duration: %dms", className, methodName, duration);
      
      if (duration >= 1000) {
        logger.error(logMessage);
      } else if (duration >= 500) {
        logger.warn(logMessage);
      } else {
        logger.info(logMessage);
      }
    }
    
    return result;
  }
  
}

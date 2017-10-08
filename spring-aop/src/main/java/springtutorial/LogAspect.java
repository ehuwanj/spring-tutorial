package springtutorial;

import java.lang.reflect.Method;

import org.aopalliance.aop.Advice;
import org.aspectj.lang.JoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.Advisor;
import org.springframework.aop.BeforeAdvice;
import org.springframework.aop.MethodBeforeAdvice;


public class LogAspect implements MethodBeforeAdvice
{
    final Logger _logger = LoggerFactory.getLogger(LogAspect.class);

    public void activateContract() {};

    public void initialLogging()
    {
        _logger.info("initiate logging for contract");
    }


    public void commitLogging(JoinPoint pJoinPoint)
    {
        _logger.info("commit logging for contract");
    }

    public void before(Method method, Object[] args, Object target) throws Throwable {
        
        _logger.info("start log for contract before execution");
        
    }


}

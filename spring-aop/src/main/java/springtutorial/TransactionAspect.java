package springtutorial;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
public class TransactionAspect
{
    final Logger _logger = LoggerFactory.getLogger(TransactionAspect.class);

    @Pointcut("execution(* springturorial.Contract.activate())")
    public void activateContract() {};

    @Before("activateContract()")
    public void initialTransaction(JoinPoint pJoinPoint)
    {
        _logger.info("initiate transaction for contract");
        _logger.info("start to process contract with method: " + pJoinPoint.toString());
    }

    @After("activateContract()")
    public void commitTransaction(JoinPoint pJoinPoint)
    {
        _logger.info("The contract method is finished: " + pJoinPoint.toString());
        _logger.info("commit transaction for contract");
    }
}

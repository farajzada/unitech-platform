package az.unitech.mscurrency.logging;

import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Log4j2
public class CurrencyAOP {

    @Pointcut(value = "execution(* az.unitech.mscurrency.service.CurrencyRateService.*(..))")
    public void logForCurrency(){}

    @Before(value = "logForCurrency()")
    public void logBeforeCurrencyService(JoinPoint joinPoint){
        log.info("Method start successfully: {}",joinPoint.getSignature().getName());
    }

    @After(value = "logForCurrency()")
    public void logAfterFightService(JoinPoint joinPoint) {
        log.info("Method finished successfully: {} ",joinPoint.getSignature().getName());
    }

    @AfterReturning(value = "logForCurrency()",returning = "result")
    public void logRunningFlightService(JoinPoint joinPoint,Object result){
        log.info("Method: {} | with result : {}",joinPoint.getSignature().getName(),result);
    }

    @AfterThrowing(value = "logForCurrency()",throwing = "ex")
    public void logExceptionFlightService(JoinPoint joinPoint,Exception ex){
        log.error("Method: {} | with exception: {}",joinPoint.getSignature().getName(),ex.getLocalizedMessage());
    }
}

package br.com.luiz.learnaop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class TrackExecutionTimeAdvice {

    @Around("br.com.luiz.learnaop.CommonPointcuts.calculateTimeExecution()")
    public Object track(ProceedingJoinPoint pjp) {
        HttpServletRequest request = Utils.getCurrentRequest();
        StopWatch sw = new StopWatch(getClass().getSimpleName());
        try {
            sw.start(pjp.getSignature().toShortString());
            return pjp.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        } finally {
            sw.stop();
            System.out.println(sw.prettyPrint());
        }
        return null;
    }
}

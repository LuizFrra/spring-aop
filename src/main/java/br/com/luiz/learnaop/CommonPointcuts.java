package br.com.luiz.learnaop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public abstract class CommonPointcuts {

    @Pointcut("@annotation(br.com.luiz.learnaop.TrackExecutionTime)")
    public final void calculateTimeExecution() {
    }
}

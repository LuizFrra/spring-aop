package br.com.luiz.learnaop;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

public class Utils {
    public static HttpServletRequest getCurrentRequest() {
        return ((ServletRequestAttributes)
                RequestContextHolder.currentRequestAttributes()).getRequest();
    }
}

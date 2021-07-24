package br.com.luiz.learnaop;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/{timeToSleep}")
    @TrackExecutionTime
    public String hello(@PathVariable(required = false) Long timeToSleep) throws InterruptedException {
        Thread.sleep(timeToSleep);
        return "Sleep: " + timeToSleep;
    }
}

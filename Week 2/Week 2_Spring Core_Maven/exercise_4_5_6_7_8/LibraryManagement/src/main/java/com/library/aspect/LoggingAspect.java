// Create a package com.library.aspect and add a class LoggingAspect.
package com.library.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class LoggingAspect {

    // Define advice methods in LoggingAspect for logging before and after method
    // execution.

    @Before("execution(* com.library.service.*.*(..))")
    public void beforeMethod() {
        System.out.println("Before method execution");
    }

    @After("execution(* com.library.service.*.*(..))")
    public void afterMethod() {
        System.out.println("After method execution");
    }
}

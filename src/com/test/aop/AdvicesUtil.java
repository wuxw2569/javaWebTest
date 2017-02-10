package com.test.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * <p class="detail">
 * 功能：通知类 -- 横切逻辑
 * </p>
 * @ClassName: AdvicesUtil 
 * @version V1.0  
 * @date 2017-2-8 
 */
@Component
@Aspect
public class AdvicesUtil {
	@Before("execution(* com.test.service.IndexService.*(..))")
    public void before(JoinPoint jp){
        System.out.println("----------前置通知----------");
        System.out.println(jp.getSignature().getName());
    }
    
    @After("execution(* com.test.service.IndexService.*(..))")
    public void after(JoinPoint jp){
        System.out.println("----------最终通知----------");
    }
}

package com.yulikexuan.cli;


import com.yulikexuan.domain.model.*;
import com.yulikexuan.domain.service.api.*;


public class Main {
    
    public static void main(String... args) throws Exception {
    
        GreetingService greetingService = GreetingService.of();
        
        String greetingMessage = greetingService.newGreeting("YUL", "Java Module");
        
        System.out.println(greetingMessage);
        
        // Reflective Access

        Object greetingService2 = Class.forName(
                "com.yulikexuan.domain.service.api.impl.GreetingServiceImpl")
                .newInstance();
                
        Object greeter = Class.forName(
                "com.yulikexuan.domain.model.Greeter")
                .newInstance();
                
        System.out.println(greetingService2.getClass().getCanonicalName());
        System.out.println(greeter.getClass().getCanonicalName());
        
        Class.forName("com.yulikexuan.domain.model.Greeter")
                .getDeclaredField("secret")
                .setAccessible(true);

    }
    
}
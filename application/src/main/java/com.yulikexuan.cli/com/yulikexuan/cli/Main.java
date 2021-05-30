package com.yulikexuan.cli;


import com.yulikexuan.domain.service.api.*;


public class Main {
    
    public static void main(String... args) {
    
        GreetingService greetingService = GreetingService.of();
        
        String greetingMessage = greetingService.newGreeting("YUL", "Java Module");
        
        System.out.println(greetingMessage);
    }
    
}
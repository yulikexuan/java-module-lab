package com.yulikexuan.domain.model;

public interface Greetings {
    
    String newGreeting(String source);
  
}

final class AppGreetings implements Greetings {
    
    @Override
    public String newGreeting(String source) {
        return String.format(">>>>>>> Greeting from %s!", source);
    }
    
}
package com.yulikexuan.domain.util;

public interface Greetings {
    
    String newGreeting(String from);
    String newGreeting(String from, String to);
    
    static Greetings of() {
        return new AppGreetings();
    }
  
}

final class AppGreetings implements Greetings {
    
    static final String GREETING_TEMPLATE = ">>>>>>> Hello %s, I am %s.";
    
    @Override
    public String newGreeting(String from) {
        return String.format(">>>>>>> Greeting from %s!", from);
    }
    
    @Override
    public String newGreeting(String from, String to) {
        return String.format(GREETING_TEMPLATE, to, from);
    }
    
}
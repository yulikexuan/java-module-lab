//: com.yulikexuan.domain.service.api.impl.GreetingServiceImpl.java

package com.yulikexuan.domain.service.api.impl;


import com.yulikexuan.domain.util.*;
import com.yulikexuan.domain.service.api.*;
import java.util.logging.Logger;


public class GreetingServiceImpl implements GreetingService {

    private final Greetings greetings;
    
    public GreetingServiceImpl() {
        this.greetings = Greetings.of();
    }
    
    private GreetingServiceImpl(Greetings greetings) {
        this.greetings = greetings;
    }
    
    public static GreetingService of(Greetings greetings) {
        return new GreetingServiceImpl(greetings);
    }

    @Override
    public String newGreeting(String from, String to) {
        return this.greetings.newGreeting(from, to);
    }
  
}
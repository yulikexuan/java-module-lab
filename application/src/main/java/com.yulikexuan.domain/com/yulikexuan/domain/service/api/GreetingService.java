//: com.yulikexuan.domain.service.api.GreetingService.java

package com.yulikexuan.domain.service.api;


import com.yulikexuan.domain.service.api.impl.*;
import com.yulikexuan.domain.util.*;


public interface GreetingService {

    String newGreeting(String from, String to);
  
    static GreetingService of() {
        return GreetingServiceImpl.of(Greetings.of());
    }
}
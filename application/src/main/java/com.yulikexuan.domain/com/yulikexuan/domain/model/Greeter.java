//: com.yulikexuan.domain.model.Greeter.java

package com.yulikexuan.domain.model;


import com.yulikexuan.domain.util.*;


public class Greeter {

    public String greeting() {
        return Greetings.of().newGreeting("domain.model");
    }
  
}
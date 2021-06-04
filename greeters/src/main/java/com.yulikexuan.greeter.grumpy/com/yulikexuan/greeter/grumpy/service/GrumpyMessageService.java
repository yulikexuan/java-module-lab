package com.yulikexuan.greeter.grumpy.service;

import com.yulikexuan.greeter.api.MessageService;

public class GrumpyMessageService implements MessageService {

    @Override
    public String getMessage() {
        return "Grumpy Greetings!";
    }

}///:~

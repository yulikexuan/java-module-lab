package com.yulikexuan.greeter.friendly.service;

import com.yulikexuan.greeter.api.MessageService;

public class FriendlyMessageService implements MessageService {

    @Override
    public String getMessage() {
        return "Friendly greetings!";
    }

}///:~

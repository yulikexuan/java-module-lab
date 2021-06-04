package com.yulikexuan.greeter.cli;

import java.util.ServiceLoader;

import com.yulikexuan.greeter.api.MessageService;

public class Main {

    public static void main(String... args) {
        Iterable<MessageService> messageServices =
                ServiceLoader.load(MessageService.class);
        for (MessageService msgService : messageServices) {
            String msg = msgService.getMessage();
            System.out.printf(">>>>>>> %s from a module!%n", msg);
        }
    }

}///:~

module com.yulikexuan.greeter.grumpy {

    requires com.yulikexuan.greeter.api;

    provides com.yulikexuan.greeter.api.MessageService
            with com.yulikexuan.greeter.grumpy.service.GrumpyMessageService;
}

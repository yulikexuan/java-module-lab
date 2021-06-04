module com.yulikexuan.greeter.formal {

    requires com.yulikexuan.greeter.api;

    provides com.yulikexuan.greeter.api.MessageService
            with com.yulikexuan.greeter.formal.service.FormalMessageService;
}

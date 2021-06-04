module com.yulikexuan.greeter.friendly {

    requires com.yulikexuan.greeter.api;

    provides com.yulikexuan.greeter.api.MessageService
            with com.yulikexuan.greeter.friendly.service.FriendlyMessageService;
}

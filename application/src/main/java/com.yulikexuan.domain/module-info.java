module com.yulikexuan.domain {
    exports com.yulikexuan.domain.model;
    exports com.yulikexuan.domain.service.api;
    opens com.yulikexuan.domain.model;
    opens com.yulikexuan.domain.service.api.impl;
}
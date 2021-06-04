package com.yulikexuan.migration;

import sun.security.x509.X500Name;

public class Legacy {

    public static void main(String... args) throws Exception {
        X500Name name = new X500Name("test.com", "test", "test", "UD");
        System.out.println(name);
    }

}

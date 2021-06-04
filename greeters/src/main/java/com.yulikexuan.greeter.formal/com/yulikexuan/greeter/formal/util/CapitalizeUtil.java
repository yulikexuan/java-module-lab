package com.yulikexuan.greeter.formal.util;

import java.util.Objects;

public class CapitalizeUtil {

    public static String capitalize(String srcString) {
        return Objects.requireNonNull(srcString).toUpperCase();
    }

}///:~

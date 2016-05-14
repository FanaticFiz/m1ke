package com.aspiration;

import java.util.HashMap;

public enum Options {
    MESSAGE("-m");

    private String optValue;

    Options(String optValue) {
        this.optValue = optValue;
    }
}

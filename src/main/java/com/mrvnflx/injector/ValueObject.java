package com.mrvnflx.injector;

/**
 * Created by mrvnf on 4/21/2017.
 */
public class ValueObject {

    private String value;

    public String getValue() {
        return value.toUpperCase();
    }

    public void setValue(String value) {
        this.value = value;
    }
}

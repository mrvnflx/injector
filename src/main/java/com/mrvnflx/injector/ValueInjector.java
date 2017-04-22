package com.mrvnflx.injector;

import java.lang.annotation.*;

/**
 * Created by mrvnf on 4/21/2017.
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ValueInjector {

    public String value();
}

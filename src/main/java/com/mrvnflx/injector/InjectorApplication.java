package com.mrvnflx.injector;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by mrvnf on 4/21/2017.
 */
@SpringBootApplication
public class InjectorApplication {

    public static void main(String[] args) {
        SpringApplication.run(InjectorApplication.class, args);
    }
}

@RestController
class InjectorDemo {

    @ValueInjector("mrvnflx")
    private ValueObject myName;

    @GetMapping(value = "/name")
    public String print() {
        return "My name is " + myName.getValue();
    }
}
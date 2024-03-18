package com.demo.ilionx.demo.aopdemo;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SomeController {

    @GetMapping("securecheck")
    @SecurityCheck
    public void doSomething() {
        System.out.println("Doing something....");
    }
}

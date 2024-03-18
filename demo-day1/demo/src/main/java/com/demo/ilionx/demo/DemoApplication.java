package com.demo.ilionx.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		ApplicationContext ac = SpringApplication.run(DemoApplication.class, args);
		for(String name: ac.getBeanDefinitionNames()) {
			System.out.println("Bean: " + name);
		}
	}

}

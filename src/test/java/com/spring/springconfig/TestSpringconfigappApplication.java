package com.spring.springconfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.TestConfiguration;

@TestConfiguration(proxyBeanMethods = false)
public class TestSpringconfigappApplication {

	public static void main(String[] args) {
		SpringApplication.from(SpringconfigApplication::main).with(TestSpringconfigappApplication.class).run(args);
	}

}

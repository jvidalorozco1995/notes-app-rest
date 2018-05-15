package com.groupsoft.rest.restApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@ComponentScan("com.groupsoft.rest")
public class RestAppApplication {

	public static void main(String[] args) {
		ApplicationContext applicationcontext = SpringApplication.run(RestAppApplication.class, args);
		for(String name : applicationcontext.getBeanDefinitionNames()) {
			System.out.println("-----------------"+name);
		}
	}
}

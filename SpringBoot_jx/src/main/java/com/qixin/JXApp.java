package com.qixin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("com.qixin.mapper")
@ComponentScan("com.qixin")
@EnableAutoConfiguration
public class JXApp {

	public static void main(String[] args) {
		SpringApplication.run(JXApp.class, args);
	}

}

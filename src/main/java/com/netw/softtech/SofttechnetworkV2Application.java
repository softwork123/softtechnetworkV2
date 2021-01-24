package com.netw.softtech;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication
public class SofttechnetworkV2Application {

	public static void main(String[] args) {
		SpringApplication.run(SofttechnetworkV2Application.class, args);
		System.out.println("This is a test");
	}

}

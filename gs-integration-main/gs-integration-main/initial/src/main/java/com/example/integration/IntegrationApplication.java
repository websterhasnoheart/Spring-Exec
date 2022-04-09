package com.example.integration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ImportResource;

import java.io.IOException;

@SpringBootApplication
@ImportResource("/integration/integration.xml")
public class IntegrationApplication {

	public static void main(String[] args) throws Exception {
		ConfigurableApplicationContext ctx = new SpringApplication(IntegrationApplication.class).run(args);
		System.out.println("Hit enter to terminate"	);
		System.in.read();
		ctx.close();
	}

}

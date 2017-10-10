package de.pschijven.entwicklertag.someservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SomeServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SomeServiceApplication.class, args);
	}
}

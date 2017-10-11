package de.pschijven.entwicklertag.kuberneteshelloworldservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;

@SpringBootApplication
public class KubernetesHelloWorldServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(KubernetesHelloWorldServiceApplication.class, args);
	}

	@RestController
	public static class HelloController {

		@GetMapping
		public String hello() throws Exception {
			String podName = InetAddress.getLocalHost().getHostName();
			return "Hello from Kubernetes Pod: " + podName;
		}

	}
}

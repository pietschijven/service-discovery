package de.pschijven.entwicklertag.kubernetesapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class KubernetesAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(KubernetesAppApplication.class, args);
	}

	@RestController
	public static class KubernetesServiceController {

		private final RestTemplate restTemplate;

		public KubernetesServiceController(final RestTemplateBuilder builder) {
			this.restTemplate = builder.build();
		}

		@GetMapping
		public String contact() {
			String result = restTemplate.getForObject("http://kubernetes-hello-world-service:9001", String.class);
			return "Received response from hello-world-service:\n\n" + result;
		}
	}
}

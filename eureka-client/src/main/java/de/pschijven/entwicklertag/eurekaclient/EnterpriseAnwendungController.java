package de.pschijven.entwicklertag.eurekaclient;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
public class EnterpriseAnwendungController {

    private final DiscoveryClient discoveryClient;
    private final RestTemplate restTemplate;

    public EnterpriseAnwendungController(final DiscoveryClient discoveryClient, final RestTemplate restTemplate) {
        this.discoveryClient = discoveryClient;
        this.restTemplate = restTemplate;
    }

    @GetMapping("/services")
    public List<ServiceInstance> allServices() {
        List<ServiceInstance> instances = new ArrayList<>();
        for (String service : discoveryClient.getServices()) {
            instances.addAll(discoveryClient.getInstances(service));
        }
        return instances;
    }

    @GetMapping("/hello")
    public String hello() {
        return restTemplate.getForObject("http://some-service/hello", String.class);
    }
}

package de.pschijven.entwicklertag.someservice;

import com.netflix.appinfo.EurekaInstanceConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.eureka.EurekaInstanceConfigBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SomeServiceController {

    @Autowired
    private ServiceHealth serviceHealth;

    @Autowired
    private EurekaInstanceConfigBean instanceInfo;

    @GetMapping("/toggle-health")
    public void toggleHealth() {
        serviceHealth.setHealthy(!serviceHealth.isHealthy());
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello from " + instanceInfo.getInstanceId();
    }

}

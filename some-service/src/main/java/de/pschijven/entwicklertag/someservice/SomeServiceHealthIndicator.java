package de.pschijven.entwicklertag.someservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health;
import org.springframework.stereotype.Component;

@Component
public class SomeServiceHealthIndicator extends AbstractHealthIndicator {

    @Autowired
    private ServiceHealth health;

    @Override
    protected void doHealthCheck(final Health.Builder builder) throws Exception {
        System.out.println("Current value of health: " + health.isHealthy());
        if (health.isHealthy()) {
            builder.up();
        } else {
            builder.down();
        }
        builder.withDetail("custom-health", health.isHealthy());
    }

}

package de.pschijven.entwicklertag.someservice;

import org.springframework.stereotype.Component;

@Component
public class ServiceHealth {
    private boolean healthy = true;

    public boolean isHealthy() {
        return healthy;
    }

    public void setHealthy(final boolean healthy) {
        this.healthy = healthy;
    }
}

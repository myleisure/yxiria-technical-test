package com.example.yxiriatechnicaltest.domain.model;

public class AllowConfiguration {
    private boolean allowed;

    public AllowConfiguration(boolean allowed) {
        this.allowed = allowed;
    }

    public boolean isAllowed() {
        return allowed;
    }

    public void setAllowed(boolean allowed) {
        this.allowed = allowed;
    }
}

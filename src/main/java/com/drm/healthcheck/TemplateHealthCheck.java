package com.drm.healthcheck;

import com.codahale.metrics.health.HealthCheck;

/**
 * Created by mmt6081 on 20/5/17.
 */
public class TemplateHealthCheck extends HealthCheck {

    private String template;

    public TemplateHealthCheck(String template) {
        this.template = template;
    }

    @Override
    protected Result check() throws Exception {
        final String greeting = String.format(template, "TEST");

        if(!greeting.contains("TEST")) {
            return Result.unhealthy("Template doesn't spit out guest's name");
        }

        return Result.healthy();
    }
}

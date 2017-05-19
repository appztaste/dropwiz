package com.drm.app;

import com.drm.config.DropHelloConfiguration;
import com.drm.controller.DropHelloController;
import com.drm.healthcheck.TemplateHealthCheck;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

/**
 * Created by mmt6081 on 19/5/17.
 */
public class DropHelloApplication extends Application<DropHelloConfiguration> {
    public static void main(String[] args) throws Exception {
        new DropHelloApplication().run(args);
    }

    @Override
    public String getName() {
        return "hello-world";
    }

    @Override
    public void initialize(Bootstrap<DropHelloConfiguration> bootstrap) {
        super.initialize(bootstrap);
    }

    @Override
    public void run(DropHelloConfiguration dropHelloConfiguration, Environment environment) throws Exception {
        DropHelloController controller = new DropHelloController(dropHelloConfiguration.getTemplate(),
                dropHelloConfiguration.getDefaultName());
        environment.jersey().register(controller);

        TemplateHealthCheck templateHealthCheck = new TemplateHealthCheck(dropHelloConfiguration.getTemplate());
        environment.healthChecks().register("template", templateHealthCheck);
    }
}

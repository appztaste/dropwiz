package com.drm.controller;

import com.codahale.metrics.annotation.Timed;
import com.drm.domain.DropHelloContent;
import com.google.common.base.Optional;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by mmt6081 on 20/5/17.
 */
@Path("/hello-world")
@Produces(MediaType.APPLICATION_JSON)
public class DropHelloController {
    private String template;
    private String defaultName;
    private AtomicInteger counter;

    public DropHelloController(String template, String defaultName) {
        this.template = template;
        this.defaultName = defaultName;
        this.counter = new AtomicInteger();
    }

    @GET
    @Timed
    public DropHelloContent sayHello(@QueryParam("name") Optional<String> name) {
        final String value = String.format(template, name.or(defaultName));
        return new DropHelloContent(counter.incrementAndGet(), value);
    }
}

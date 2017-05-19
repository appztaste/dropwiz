package com.drm.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

/**
 * Created by mmt6081 on 20/5/17.
 */
public class DropHelloContent {
    private int id;

    @Length(max = 3)
    private String content;

    public DropHelloContent(int id, String content) {
        this.id = id;
        this.content = content;
    }

    @JsonProperty
    public int getId() {
        return id;
    }

    @JsonProperty
    public String getContent() {
        return content;
    }
}

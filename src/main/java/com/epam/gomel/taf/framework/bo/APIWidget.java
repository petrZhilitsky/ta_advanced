package com.epam.gomel.taf.framework.bo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class APIWidget {
    @JsonProperty("id")
    private int id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("description")
    private String description;
    @JsonProperty("owner")
    private String owner;
    @JsonProperty("share")
    private boolean share;
    @JsonProperty("widgetType")
    private String widgetType;
    @JsonProperty("appliedFilters")
    private Object appliedFilters;
    @JsonProperty("content")
    private Object content;
    @JsonProperty("contentParameters")
    private Object contentParameters;
}

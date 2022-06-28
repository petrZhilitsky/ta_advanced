package com.epam.gomel.taf.framework.bo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class APIDashboard {
    @JsonProperty("id")
    private int id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("owner")
    private String owner;
    @JsonProperty("share")
    private boolean share;
    @JsonProperty("widgets")
    private Object widgets;
}

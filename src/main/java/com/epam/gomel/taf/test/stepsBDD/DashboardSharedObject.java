package com.epam.gomel.taf.test.stepsBDD;

import io.cucumber.guice.ScenarioScoped;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;

@ScenarioScoped
@Getter
@Setter
@NoArgsConstructor
public class DashboardSharedObject {
    String dashboardName;
    String dashboardDescription = randomAlphabetic(10);;
}

package com.epam.gomel.taf.framework.factory;

public class Constants {
    public static final String USER_LOGIN = Configurations.getInstance().getProperty("user.login");
    public static final String USER_PASSWORD = Configurations.getInstance().getProperty("user.password");
    public static final String ADMIN_LOGIN = Configurations.getInstance().getProperty("admin.login");
    public static final String ADMIN_PASSWORD = Configurations.getInstance().getProperty("admin.password");
    public static final String RP_URL_LOG_IN = Configurations.getInstance().getProperty("rp.url");
    public static final String API_TOKEN = Configurations.getInstance().getProperty("rp.token");
    public static final String SLACK_URL = Configurations.getInstance().getProperty("slack.url");
    public static final String JIRA_LOGIN = Configurations.getInstance().getProperty("jira.login");
    public static final String JIRA_PASSWORD = Configurations.getInstance().getProperty("jira.password");
    public static final String JIRA_URL = Configurations.getInstance().getProperty("jira.url");
    public static final String SAUCELABS_URL = Configurations.getInstance().getProperty("remote.url");
}

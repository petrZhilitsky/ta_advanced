package com.epam.gomel.taf.framework.utils;

import com.atlassian.jira.rest.client.api.IssueRestClient;
import com.atlassian.jira.rest.client.api.JiraRestClient;
import com.atlassian.jira.rest.client.api.domain.Issue;
import com.atlassian.jira.rest.client.api.domain.Transition;
import com.atlassian.jira.rest.client.api.domain.input.TransitionInput;
import com.atlassian.jira.rest.client.internal.async.AsynchronousJiraRestClientFactory;
import com.epam.gomel.taf.framework.factory.Constants;

import java.net.URI;

public class JiraService {
    private static JiraRestClient getJiraRestClient() {
        return new AsynchronousJiraRestClientFactory()
                .createWithBasicHttpAuthentication(URI.create(Constants.JIRA_URL), Constants.JIRA_LOGIN, Constants.JIRA_PASSWORD);
    }

    public static void updateIssueStatus(String issueKey, String status) {
        IssueRestClient issueClient = getJiraRestClient().getIssueClient();
        Issue issue = issueClient.getIssue(issueKey).claim();
        Iterable<Transition> transitions = issueClient.getTransitions(issue).claim();

        for (Transition transition : transitions) {
            if (transition.getName().equals(status)) {
                TransitionInput input = new TransitionInput(transition.getId());
                issueClient.transition(issue, input).claim();
                break;
            }
        }
    }
}

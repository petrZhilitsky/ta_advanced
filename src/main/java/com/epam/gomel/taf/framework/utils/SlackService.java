package com.epam.gomel.taf.framework.utils;

import com.epam.gomel.taf.framework.factory.Constants;
import com.epam.gomel.taf.framework.logger.Log;
import com.github.seratch.jslack.Slack;
import com.github.seratch.jslack.api.webhook.Payload;
import com.github.seratch.jslack.api.webhook.WebhookResponse;

public class SlackService {
    public static void send(String message) {
        try {
            StringBuilder msgBuilder = new StringBuilder();
            msgBuilder.append(message);
            Payload payload = Payload.builder().channel("taf_advanced").text(msgBuilder.toString()).build();
            WebhookResponse response = Slack.getInstance().send(Constants.SLACK_URL, payload);
        } catch (Exception e) {
            Log.error(e.getMessage());
        }
    }
}

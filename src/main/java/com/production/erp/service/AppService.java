package com.production.erp.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.github.seratch.jslack.Slack;
import com.github.seratch.jslack.api.webhook.Payload;
import com.github.seratch.jslack.api.webhook.WebhookResponse;

import java.io.IOException;

@Service
public class AppService {
    private static final Logger LOGGER = LoggerFactory.getLogger(AppService.class);
    private static final String NEW_LINE = "\n";

    @Value("${slack.webhook}")
    private String urlSlackWebHook;

    public void sendMessageToSlack(String message) {

        StringBuilder messageBuider = new StringBuilder();
        messageBuider.append("message: " + message + NEW_LINE);

        process(messageBuider.toString());
    }

    private void process(String message) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Payload payload = Payload.builder()
                .channel("#spring")
                .username(authentication.getName())
                .iconEmoji(":rocket:")
                .text(message)
                .build();
        try {
            WebhookResponse webhookResponse = Slack.getInstance().send(
                    urlSlackWebHook, payload);
            LOGGER.info("code -> " + webhookResponse.getCode());
            LOGGER.info("body -> " + webhookResponse.getBody());
        } catch (IOException e) {
            LOGGER.error("Unexpected Error! WebHook:" + urlSlackWebHook);
        }
    }
}

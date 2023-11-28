package com.woopiii.alarm.api.slack;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.slack.api.Slack;
import com.slack.api.webhook.WebhookResponse;

@RestController
@RequestMapping(value = "/alarm/slack")
public class SlackAlarmController {
    
    //GetMethod
    @GetMapping
    public String getAlarm () {

        String sampleUrl = "https://hooks.slack.com/services/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";

        Slack slack = Slack.getInstance();

        String payload = """
            {
                "username" : "woopiii-system",
                "icon_emoji": ":ghost:",
                "text" : "메시지 테스트"
            }        
        """;

        try {
            WebhookResponse response = slack.send(sampleUrl, payload);
            System.out.println(response);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "get ok";
    } 
    //PostMethod
    @PostMapping
    public String postAlarm () {
        return "ok";
    } 
    //PatchMethod
    //DeleteMethod

}

package com.woopiii.alarm.api.alarm;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.slack.api.Slack;
import com.slack.api.webhook.WebhookResponse;

@RestController
@RequestMapping(value = "/alarm")
public class AlarmController {
    
    //GetMethod
    @GetMapping
    public String getAlarm () {

        String sampleUrl = "https://hooks.slack.com/services/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";

        Slack slack = Slack.getInstance();

        String payload = """
            {
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

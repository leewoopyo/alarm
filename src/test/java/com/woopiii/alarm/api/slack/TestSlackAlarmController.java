package com.woopiii.alarm.api.slack;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("tst")
public class TestSlackAlarmController {

    private final TestRestTemplate testRestTemplate = new TestRestTemplate();

    @Test
    public void testApiCall () {

        String apiUrl = "http://localhost:8080/alarm/slack";

        ResponseEntity<String> response = testRestTemplate.getForEntity(apiUrl, String.class);

        System.out.println(response.getBody());

        // 응답 코드 확인
        assertEquals(200, response.getStatusCode().value());

    }
    
}

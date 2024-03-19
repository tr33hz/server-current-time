package com.tele2.servertime.currentTime;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CurrentTimeControllerIntegrationTest {

    @LocalServerPort
    private int port;

    private final TestRestTemplate restTemplate = new TestRestTemplate();

    @Test
    void testGetCurrentTime() {
        String url = "http://localhost:" + port + "/api/current-time";
        String response = restTemplate.getForObject(url, String.class);
        assertThat(response).contains("\"currentTime\"");
        assertThat(response).contains("\"timezone\"");
    }
}

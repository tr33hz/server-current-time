package com.tele2.servertime;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

@RestController
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
@RequestMapping("/api")
public class CurrentTimeController {

    CurrentTimeService currentTimeService;

    @GetMapping("/current-time")
    public Map<String, String> getCurrentTime() {
        LocalDateTime currentTime = currentTimeService.getCurrentTime();
        ZoneId zoneId = ZoneId.systemDefault();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        Map<String, String> response = new HashMap<>();
        response.put("currentTime", currentTime.format(formatter));
        response.put("timezone", zoneId.toString());

        return response;
    }

}

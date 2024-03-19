package com.tele2.servertime;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class CurrentTimeService {
    public LocalDateTime getCurrentTime() {
        return LocalDateTime.now();
    }
}

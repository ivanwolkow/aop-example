package com.example.aopexample;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@Slf4j
public class BasicService {

    public String extractDate(LocalDateTime dateTime) {
        log.info("Default logging inside method");
        return dateTime.toLocalDate().toString();
    }

    public void throwingMethod(String in) {
        if (in == null) throw new RuntimeException("Bad arguments");
    }

}

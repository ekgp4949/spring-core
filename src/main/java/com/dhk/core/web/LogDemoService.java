package com.dhk.core.web;

import com.dhk.core.common.MyLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LogDemoService {

    private final MyLogger myLogger;

    public void logic(String str) {
        myLogger.log("service id: " + str);
    }
}

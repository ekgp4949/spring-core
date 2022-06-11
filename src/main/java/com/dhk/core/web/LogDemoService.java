package com.dhk.core.web;

import com.dhk.core.common.MyLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LogDemoService {

    private final ObjectProvider<MyLogger> myLoggerProvider;

    public void logic(String str) {
        MyLogger myLogger = myLoggerProvider.getObject();
        myLogger.log("service id: " + str);
    }
}

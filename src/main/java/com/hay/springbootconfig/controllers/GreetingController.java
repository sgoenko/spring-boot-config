package com.hay.springbootconfig.controllers;

import com.hay.springbootconfig.util.DbSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class GreetingController {

    @Value("${my.greeting: default value}")
    private String greetingMessage;

    @Value("Static message")
    private String staticMessage;

    @Value("${my.list.values}")
    private List<String> numbers;

    @Value("#{${db.connection}}")
    private Map<String, String> dbValues;

    @Autowired
    private DbSettings dbSettings;

    @GetMapping("/greeting")
    public List<String> greeting() {
        return numbers;
    }

    @GetMapping("/dbsettings")
    public String getDbSettings() {
        return dbSettings.toString();
    }

    @GetMapping("/dbValues")
    public Map<String, String> getDbValues() {
        return dbValues;
    }
}

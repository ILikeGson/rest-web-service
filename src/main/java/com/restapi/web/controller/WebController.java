package com.restapi.web.controller;

import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
public class WebController {
    private MessageSource messageSource;

    public WebController(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @GetMapping("/")
    public String hello(@RequestHeader(name = "Accept-Language") Locale locale) {
        return messageSource.getMessage("good.morning.message", null, locale);
    }

}

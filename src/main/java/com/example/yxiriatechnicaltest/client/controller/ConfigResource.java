package com.example.yxiriatechnicaltest.client.controller;

import com.example.yxiriatechnicaltest.domain.port.in.ConfigService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

@RestController
@RequestMapping(value = "/config")
public class ConfigResource {

    private final ConfigService configService;

    public ConfigResource(ConfigService configService) {
        this.configService = configService;
    }

    @GetMapping
    public Map<String, Boolean> getConfig() throws IOException {
        return Map.of("config", configService.isConfigAllowed());
    }
}

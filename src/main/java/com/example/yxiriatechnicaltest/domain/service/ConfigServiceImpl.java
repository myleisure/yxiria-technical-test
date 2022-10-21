package com.example.yxiriatechnicaltest.domain.service;

import com.example.yxiriatechnicaltest.domain.model.AllowConfiguration;
import com.example.yxiriatechnicaltest.domain.port.in.ConfigService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

@Service
public class ConfigServiceImpl implements ConfigService {

    private final String configFileLocation;

    public ConfigServiceImpl(@Value("${allowed-config.location}") String configFileLocation) {
        this.configFileLocation = configFileLocation;
    }

    @Override
    public boolean isConfigAllowed()  {
        AllowConfiguration configuration = new AllowConfiguration(false);
        try(Stream<String> lines = Files.lines(Paths.get(configFileLocation))) {
            lines.forEach(line -> {
                String[] splittedLine = line.split(":");
                if (splittedLine.length == 1)
                    throw new IllegalArgumentException("File should contains a valid config");
                configuration.setAllowed(Boolean.parseBoolean(splittedLine[1].trim()));
            });
        } catch (IOException e) {
            configuration.setAllowed(false);
        }
        return configuration.isAllowed();
    }
}

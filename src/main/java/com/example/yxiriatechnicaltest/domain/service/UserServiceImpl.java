package com.example.yxiriatechnicaltest.domain.service;

import com.example.yxiriatechnicaltest.domain.exception.UserReadNotAllowedException;
import com.example.yxiriatechnicaltest.domain.exception.UserNotFoundException;
import com.example.yxiriatechnicaltest.domain.model.User;
import com.example.yxiriatechnicaltest.domain.port.in.ConfigService;
import com.example.yxiriatechnicaltest.domain.port.in.UserService;
import com.example.yxiriatechnicaltest.domain.port.out.UserPort;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserPort userPort;
    private final ConfigService configService;

    public UserServiceImpl(UserPort userPort, ConfigService configService) {
        this.userPort = userPort;
        this.configService = configService;
    }

    @Override
    public User getById(int id) throws UserReadNotAllowedException {
        if (!configService.isConfigAllowed())
            throw new UserReadNotAllowedException("Configuration is disabled, you are not allowed to get this user");
        return userPort.getUserById(id)
                .orElseThrow(() -> new UserNotFoundException("User with id " + id + " cannot be found"));
    }

    @Override
    public User create(User user) {
        return userPort.create(user);
    }
}

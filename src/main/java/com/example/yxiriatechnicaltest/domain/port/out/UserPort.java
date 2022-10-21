package com.example.yxiriatechnicaltest.domain.port.out;

import com.example.yxiriatechnicaltest.domain.model.User;

import java.util.Optional;

public interface UserPort {
    User create(User user);
    Optional<User> getUserById(int id);
}

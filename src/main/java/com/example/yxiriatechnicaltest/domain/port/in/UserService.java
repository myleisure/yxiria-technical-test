package com.example.yxiriatechnicaltest.domain.port.in;

import com.example.yxiriatechnicaltest.domain.exception.UserReadNotAllowedException;
import com.example.yxiriatechnicaltest.domain.model.User;

public interface UserService {
    User getById(int id) throws UserReadNotAllowedException;
    User create(User user);
}

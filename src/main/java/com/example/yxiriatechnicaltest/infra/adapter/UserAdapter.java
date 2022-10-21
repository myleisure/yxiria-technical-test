package com.example.yxiriatechnicaltest.infra.adapter;

import com.example.yxiriatechnicaltest.domain.model.User;
import com.example.yxiriatechnicaltest.domain.port.out.UserPort;
import com.example.yxiriatechnicaltest.infra.entity.UserEntity;
import com.example.yxiriatechnicaltest.infra.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserAdapter implements UserPort {
    private final UserRepository userRepository;

    public UserAdapter(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User create(User user) {
        UserEntity savedUser = userRepository.save(new UserEntity(user.getFirstname(), user.getLastname()));
        return new User(savedUser.getId(), savedUser.getFirstname(), savedUser.getLastname());
    }

    @Override
    public Optional<User> getUserById(int id) {
        return userRepository.findById(id)
                .map(entity -> new User(entity.getId(), entity.getFirstname(), entity.getLastname()));
    }
}

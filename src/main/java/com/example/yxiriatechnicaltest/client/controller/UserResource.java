package com.example.yxiriatechnicaltest.client.controller;

import com.example.yxiriatechnicaltest.client.dto.UserDto;
import com.example.yxiriatechnicaltest.domain.exception.UserReadNotAllowedException;
import com.example.yxiriatechnicaltest.domain.model.User;
import com.example.yxiriatechnicaltest.domain.port.in.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    private final UserService userService;

    public UserResource(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/{id}")
    public UserDto getUserById(@PathVariable int id) throws UserReadNotAllowedException {
        return mapToDto(userService.getById(id));
    }

    @PostMapping
    public int create(@RequestBody UserDto userDto) {
        User user = userService.create(new User(userDto.firstname(), userDto.lastname()));
        return user.getId();
    }

    private static UserDto mapToDto(User user) {
        return new UserDto(user.getFirstname(), user.getLastname());
    }
}

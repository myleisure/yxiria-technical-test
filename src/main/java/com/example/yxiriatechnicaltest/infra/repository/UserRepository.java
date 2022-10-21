package com.example.yxiriatechnicaltest.infra.repository;

import com.example.yxiriatechnicaltest.infra.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity, Integer> {
}

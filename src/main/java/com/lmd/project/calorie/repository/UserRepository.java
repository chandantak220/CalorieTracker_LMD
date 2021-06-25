package com.lmd.project.calorie.repository;

import org.springframework.data.repository.CrudRepository;

import com.lmd.project.calorie.model.User;

public interface UserRepository extends CrudRepository<User, Long> {
}

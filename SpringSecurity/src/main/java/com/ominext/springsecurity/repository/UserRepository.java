package com.ominext.springsecurity.repository;

import org.springframework.data.repository.CrudRepository;

import com.ominext.springsecurity.domain.User;

public interface UserRepository extends CrudRepository<User, Integer> {

	User findByEmail(String email);
}

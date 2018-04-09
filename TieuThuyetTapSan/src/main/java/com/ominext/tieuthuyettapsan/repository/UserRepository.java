package com.ominext.tieuthuyettapsan.repository;

import org.springframework.data.repository.CrudRepository;

import com.ominext.tieuthuyettapsan.domain.User;

public interface UserRepository extends CrudRepository<User, Integer> {

	User findByEmail(String email);
}

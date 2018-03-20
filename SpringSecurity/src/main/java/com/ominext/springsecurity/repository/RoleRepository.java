package com.ominext.springsecurity.repository;

import org.springframework.data.repository.CrudRepository;

import com.ominext.springsecurity.domain.Role;

public interface RoleRepository extends CrudRepository<Role, Integer> {

	Role findByName(String name);
}

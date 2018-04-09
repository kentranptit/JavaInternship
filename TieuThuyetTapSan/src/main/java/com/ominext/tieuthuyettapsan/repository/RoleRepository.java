package com.ominext.tieuthuyettapsan.repository;

import org.springframework.data.repository.CrudRepository;

import com.ominext.tieuthuyettapsan.domain.Role;

public interface RoleRepository extends CrudRepository<Role, Integer> {

	Role findByName(String name);
}

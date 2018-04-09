package com.ominext.tieuthuyettapsan.config;

import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.ominext.tieuthuyettapsan.domain.Role;
import com.ominext.tieuthuyettapsan.domain.User;
import com.ominext.tieuthuyettapsan.repository.RoleRepository;
import com.ominext.tieuthuyettapsan.repository.UserRepository;

@Component
public class DataSeedingListener implements ApplicationListener<ContextRefreshedEvent> {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		//Roles
		if (roleRepository.findByName("ROLE_ADMIN") == null) {
			roleRepository.save(new Role("ROLE_ADMIN"));
		}
		
		if (roleRepository.findByName("ROLE_MEMBER") == null) {
			roleRepository.save(new Role("ROLE_MEMBER"));
		}
		
		//Admin account
		if (userRepository.findByEmail("admin@gmail.com") == null) {
			User admin = new User();
			admin.setEmail("admin@gmail.com");
			admin.setPassword(passwordEncoder.encode("ad123"));
			HashSet<Role> roles = new HashSet<>();
			roles.add(roleRepository.findByName("ROLE_ADMIN"));
			roles.add(roleRepository.findByName("ROLE_MEMBER"));
			admin.setRoles(roles);
			userRepository.save(admin);
		}
		
		//Member account
		if (userRepository.findByEmail("member@gmail.com") == null) {
			User member = new User();
			member.setEmail("member@gmail.com");
			member.setPassword(passwordEncoder.encode("mem123"));
			HashSet<Role> roles = new HashSet<>();
			roles.add(roleRepository.findByName("ROLE_MEMBER"));
			member.setRoles(roles);
			userRepository.save(member);
		}
	}

}

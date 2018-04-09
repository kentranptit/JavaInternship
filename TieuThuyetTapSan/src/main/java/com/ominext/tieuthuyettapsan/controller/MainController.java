package com.ominext.tieuthuyettapsan.controller;

import java.util.HashSet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ominext.tieuthuyettapsan.domain.Role;
import com.ominext.tieuthuyettapsan.domain.User;
import com.ominext.tieuthuyettapsan.repository.RoleRepository;
import com.ominext.tieuthuyettapsan.service.UserDetailsServiceImpl;

@Controller
public class MainController {

	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private UserDetailsServiceImpl userDetailsService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index() {
		return "index";
	}

	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String admin() {
		return "admin";
	}

	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public String accessDenied() {
		return "403";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String getLogin() {
		return "login";
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String showRegister(Model model) {
		model.addAttribute("user", new User());
		return "register";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String save(@Valid User user, @RequestParam("password") String password, BindingResult result) {
		if (result.hasErrors()) {
			return "register";
		}
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		user.setPassword(encoder.encode(password));
		HashSet<Role> roles = new HashSet<>();
		roles.add(roleRepository.findByName("ROLE_MEMBER"));
		user.setRoles(roles);
		userDetailsService.saveRegisteringInfo(user);
		return "redirect:/login";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		return "redirect:/";
	}

}

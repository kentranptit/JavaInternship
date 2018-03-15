package com.ominext.springbootvalidation.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ominext.springbootvalidation.model.TeacherForm;

@Controller
public class TeacherController {

	@GetMapping("/teacher")
	public String showForm(Model model) {
		model.addAttribute("teacherForm", new TeacherForm());
		return "form";
	}
	
	@PostMapping("/teacher")
	public String checkTeacherInfo(@Valid @ModelAttribute TeacherForm teacherForm, BindingResult result) {
		if (result.hasErrors()) {
			return "form";
		}
		
		return "result";
	}

}

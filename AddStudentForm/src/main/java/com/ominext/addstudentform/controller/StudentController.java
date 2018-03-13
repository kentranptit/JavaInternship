package com.ominext.addstudentform.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ominext.addstudentform.model.Student;

@Controller
public class StudentController {

	@GetMapping("/addstudent")
	public String addStudent(Model model) {
		model.addAttribute("student", new Student());
		model.addAttribute("favoritesList", initFavorites());
		model.addAttribute("majorsList", initMajors());
		return "add_student";
	}
	
	@PostMapping("/addstudent/result")
	public String resultStudent(@ModelAttribute Student student) {
		return "result";
	}
	
	private List<String> initFavorites() {
		List<String> favoritesList = new ArrayList<String>();
		favoritesList.add("Swimming");
		favoritesList.add("Listening music");
		favoritesList.add("Walking");
		favoritesList.add("Watching movie");
		favoritesList.add("Reading comic");
		return favoritesList;
	}
	
	private List<String> initMajors() {
		List<String> majorsList = new ArrayList<String>();
		majorsList.add("Computer Science");
		majorsList.add("Economics");
		majorsList.add("English Language and Literature");
		majorsList.add("Chemical Engineering");
		majorsList.add("Biology");
		return majorsList;
	}
}

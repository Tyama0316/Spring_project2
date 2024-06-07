package com.example.demo.fizzBuzz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FizzBuzzController {

	@Autowired
	private FizzBuzzService fizzBuzzService;

	@GetMapping("/fizzbuzz")
	public String showFizzBuzz(Model model) {
		model.addAttribute("numbers", fizzBuzzService.getFizzBuzzList());
		return "fizzBuzz";
	}
}
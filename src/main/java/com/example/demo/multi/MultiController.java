package com.example.demo.multi;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MultiController {

	private final MultiService multiService;

	public MultiController(MultiService multiService) {
		this.multiService = multiService;
	}

	@GetMapping("/multi")
	public String multiply(Model model) {
		int result = multiService.multiply(5, 6);
		model.addAttribute("result", result);
		return "multi";
	}
}
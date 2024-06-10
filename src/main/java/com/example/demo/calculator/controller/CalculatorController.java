package com.example.demo.calculator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.calculator.service.CalculatorService;

@Controller
public class CalculatorController {

    @Autowired
    private CalculatorService calculatorService;

    @GetMapping("/calculator")
    public String showCalculator() {
        return "calculator";
    }

    @PostMapping("/calculator")
    public String calculate(@RequestParam("number1") int number1, 
                            @RequestParam("number2") int number2, 
                            @RequestParam("operation") String operation, 
                            Model model) {
        int result = calculatorService.calculate(number1, number2, operation);
        model.addAttribute("result", result);
        return "calculator";
    }
}
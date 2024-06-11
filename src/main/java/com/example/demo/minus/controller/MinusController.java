package com.example.demo.minus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.minus.service.MinusService;

@Controller
public class MinusController {

    @Autowired
    private MinusService minusService;

    @GetMapping("/minus")
    public String showMinusForm() {
        return "minus.html";
    }

    @PostMapping("/calculateMinus")
    public String calculateMinus(@RequestParam(value = "number1", required = false) String number1,
                                 @RequestParam(value = "number2", required = false) String number2,
                                 Model model) {
        if (number1 == null || number1.isEmpty() || number2 == null || number2.isEmpty()) {
            model.addAttribute("error", "両方の数字を入力してください。");
            return "minus.html";
        }
        try {
            int num1 = Integer.parseInt(number1);
            int num2 = Integer.parseInt(number2);
            int result = minusService.subtract(num1, num2);
            model.addAttribute("result", result);
        } catch (NumberFormatException e) {
            model.addAttribute("error", "有効な数字を入力してください。");
        }
        return "minus.html";
    }
}
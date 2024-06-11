package com.example.demo.calculator.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService {

    public int calculate(int number1, int number2, String operation) {
        switch (operation) {
            case "+":
                return number1 + number2;
            case "-":
                return number1 - number2;
            case "*":
                return number1 * number2;
            case "/":
                if (number2 != 0) {
                    return number1 / number2;
                } else {
                    throw new IllegalArgumentException("ゼロで除算することはできません。");
                }
            default:
                throw new IllegalArgumentException("無効な演算です。");
        }
    }
}
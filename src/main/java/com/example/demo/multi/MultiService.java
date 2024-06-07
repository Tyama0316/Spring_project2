package com.example.demo.multi;

import org.springframework.stereotype.Service;

@Service
public class MultiService {

	public int multiply(int num1, int num2) {
		return num1 * num2;
	}
}
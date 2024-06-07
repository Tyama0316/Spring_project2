package com.example.demo.fizzBuzz;

public class PracticeIf {

	public static void main(String[] args) {
		for (int number = 1; number <= 100; number++) {
			if (number % 3 == 0 && number % 5 == 0) {
				System.out.println("FIzzBuzz");
			} else if (number % 3 == 0) {
				System.out.println("FIzz");
			} else if (number % 5 == 0) {
				System.out.println("Buzz");
			} else {
				System.out.println(number);
			}
		}
	}

}
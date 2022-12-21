package com.basic.function;

public class BasicFunction {

	public static void main(String[] args) {
		
		System.out.println("Addition of numbers: "+Addition(12,23));
		System.out.println("Subtraction of numbers: "+Subtraction(62,23));
		System.out.println("Multiplication of numbers: "+Multiplication(12,23));
		System.out.println("Division of numbers: "+Division(46,23));
		System.out.println("Square of numbers: "+Square(12));
		System.out.println("Cube of numbers: "+Cube(12));
		

	}
	
	static Integer Addition(Integer num1,Integer num2) {
		return num1+num2;
	}
	static Integer Subtraction(Integer num1,Integer num2) {
		return num1-num2;
	}
	static Integer Multiplication(Integer num1,Integer num2) {
		return num1*num2;
	}
	static Integer Division(Integer num1,Integer num2) {
		return num1/num2;
	}
	static Integer Square(Integer num) {
		return num*num;
	}
	static Integer Cube(Integer num) {
		return num*num*num;
	}
	

}

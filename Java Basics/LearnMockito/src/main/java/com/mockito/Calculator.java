package com.mockito;

public class Calculator {

	CalculatorService service;
	public Calculator(CalculatorService service) {
		this.service=service;
	}
	public int add(Integer num1,Integer num2) {
		return num1+num2;
	}
	public int sub(Integer num1,Integer num2) {
		return num1-num2;
	}
	public int mul(Integer num1,Integer num2) {
		return num1*num2;
	}
	
	public int perform(int i, int j) {
		return (i+j);
	}
	public int perform1(int i, int j) {
		return (i-j);
	}
	public int perform2(int i, int j) {
		return (i*j);
	}
	
}

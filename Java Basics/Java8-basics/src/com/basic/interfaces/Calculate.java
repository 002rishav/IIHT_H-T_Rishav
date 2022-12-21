package com.basic.interfaces;

interface Square{
	void square();
	static Integer sq(Integer x) {return x*x;}
}// in Java 8 you get a feature to add a body to interface method

public class Calculate {

	public static void main(String[] args) {
		Square sq=new SquareOf10();
		sq.square();
		System.out.println(Square.sq(10));
		
	}
	
}

class SquareOf10 implements Square{

	@Override
	public void square() {
		// TODO Auto-generated method stub
		System.out.println("Square of the number is: ");
	}
	
}

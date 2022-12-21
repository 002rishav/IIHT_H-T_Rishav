package com.basic.lambda;


interface SayHello {
	public void hello();
}
public class LearnLambda {
	
	//parameter -> expression body
	public static void main(String[] args) {
		System.out.println("Hello World");
		
		SayHello h=new SayHello() {
			
			@Override
			public void hello(){
				System.out.println("Hello from Rishav Roy");
			}
			};
			
		h.hello();

		SayHello h2= ()->System.out.println("Hello from Rishav");
		
		h2.hello();
		
		
		LearnLambda learn=new LearnLambda();
		
		MathOperation add= (Integer num1,Integer num2)-> num1+num2;
		
		MathOperation sub= (Integer num1,Integer num2)-> num1-num2;
		
		MathOperation mul= (Integer num1,Integer num2)-> num1*num2;
		
		MathOperation div= (Integer num1,Integer num2)-> num1/num2;
		
		System.out.println("addition of numbers 100,50: "+ add.Operation(100,50));
		System.out.println("subtraction of numbers 100,50: "+sub.Operation(100, 50));
		System.out.println("multiplication of numbers 100,50: "+mul.Operation(100, 50));
		System.out.println("division of numbers 100,50: "+div.Operation(100, 50));
	}
	
	
	

}

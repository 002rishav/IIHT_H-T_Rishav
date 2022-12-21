package com.basic.functionalInterface;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerDemo {

//	@Override
//	public void accept(Integer t) {
//		// TODO Auto-generated method stub
//		System.out.println("printing: "+t);
//	}
	
	public static void main(String[] args) {
		
		Consumer<Integer> consumer=(t)-> System.out.println("printing: "+t);
		consumer.accept(4000);
		
		
		List<Integer> numberList = Arrays.asList(1,2,3,4,5);
		
		//numberList.forEach(number->System.out.println("printing:" + number));
		
		numberList.stream().forEach(number->System.out.println("printing:" + number));
	}
	
	

}

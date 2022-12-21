package com.basic.functionalInterface;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PredicateDemo /*implements Predicate<Integer>*/ {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Predicate<Integer> predicate=new PredicateDemo();
//		Predicate<Integer> predicate=(t)->(t%2==0);
//		System.out.println(predicate.test(6));
		
		List<Integer> numberList = Arrays.asList(1,2,3,4,5);
		
		
		numberList.stream().filter(t->t%2==0).forEach(number->System.out.println("printing:" + number));
	}

//	@Override
//	public boolean test(Integer t) {
//		// TODO Auto-generated method stub
//		if(t%2==0) {
//			return true;
//		}
//		return false;
//	}

}

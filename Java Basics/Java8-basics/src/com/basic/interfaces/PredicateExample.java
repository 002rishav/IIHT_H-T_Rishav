package com.basic.interfaces;

import java.util.function.Predicate;

public class PredicateExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Predicate<Integer> predicate1= num -> (num>20);
		System.out.println(predicate1.test(30));
	}

}

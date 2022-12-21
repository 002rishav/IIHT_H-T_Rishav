package com.basic.functionalInterface;

import java.util.function.Supplier;

public class SupplierDemo  {

//	@Override
//	public String get() {
//		// TODO Auto-generated method stub
//		return "hello world";
//	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Supplier<String> supplier=()->"hello world";
		System.out.println(supplier.get());
	}

	

}

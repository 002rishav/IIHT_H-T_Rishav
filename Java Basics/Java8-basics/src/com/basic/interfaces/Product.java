package com.basic.interfaces;

interface manufacturing{
	void made();
}

interface sales{
	void sale();
}

public class Product implements manufacturing,sales {
	
	public static void main(String[] args) {
		
		Product soap=new Product();
		soap.made();
		soap.sale();
		
	}

	@Override
	public void made() {
		// TODO Auto-generated method stub
		System.out.println("Product has been made.");
		
	}

	@Override
	public void sale() {
		// TODO Auto-generated method stub
		System.out.println("Product is sold.");
	}
	
	

}

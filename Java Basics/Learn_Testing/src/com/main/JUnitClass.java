package com.main;

import static org.junit.Assert.*;

import org.junit.Test;

public class JUnitClass {
	
	String username="Rishav123";
	
	@Test
	public void testUserName() {
		System.out.println("Testing the username matches");
		assertEquals("Rishav1234",username);
	}
	
	@Test
	public void JUnitMethod() {
		System.out.println("Test file executed");
	}

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		JUnitClass junit=new JUnitClass();
//		junit.testUserName();
//	}
}

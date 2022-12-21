package com.mockito;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import junit.framework.TestCase;

public class TestCalculator {
	
	Calculator c =null;
//	CalculatorService service= new CalculatorService() {		
//		public int add(int num1, int num2) {
//			return 0;
//		}
//	};
	CalculatorService service = Mockito.mock(CalculatorService.class);
	
	@Before
	public void setup() {
		c =new Calculator(service);
	}
	
	@Test
	public void testAdd() {
		when(service.add(110, 40)).thenReturn(150);
		assertEquals(150,c.perform(110,40));
	}
	
	@Test
	public void testSubtract() {
		when(service.sub(110, 40)).thenReturn(70);
		assertEquals(100,c.sub(150,50));
	}
	
	@Test
	public void testMultiplication() {
		when(service.mul(100, 40)).thenReturn(4000);
		assertEquals(4000,c.mul(100,40));
	}

}

package com.basic.reference;

import java.time.LocalDate;

public class Project {
	
	public static void projectProgress() {
		System.out.println("Project is making progress");
		
		System.out.println("Project status was approved by client");
		
		LocalDate now=LocalDate.now();
		System.out.println("on "+now.toString());
		
	}
	
	public static void threadTask() {
		
		for(int i=1;i<=10;i++) {
			System.out.println(i*2);
			try {
				Thread.sleep(1000);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	public static void oddto100() {
		
		for(int i=1;i<=100;i++) {
			if(i%2!=0) {
				System.out.println(i);
			}
			try {
				Thread.sleep(10);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}

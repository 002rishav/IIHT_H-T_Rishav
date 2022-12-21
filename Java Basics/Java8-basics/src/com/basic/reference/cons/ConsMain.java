package com.basic.reference.cons;

public class ConsMain {
	
	public static void main(String[] args) {
		
		System.out.println("We are studying cont ref");
		
		IStudent iStudent= () -> new Student();
		
		Student student = iStudent.getStudent();
		
		student.display("Rishav","12");

	}

}

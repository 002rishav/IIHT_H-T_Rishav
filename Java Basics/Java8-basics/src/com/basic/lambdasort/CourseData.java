package com.basic.lambdasort;

import java.util.*;

public class CourseData {
	
	public static List<Courses> getAllCourses(){

        //Creating object for each course to be entered to the list
		Courses course1 = new Courses("1","JEE_Mains",80000.00,2,"Suman");
		Courses course2 = new Courses("2","JEE_Advanced",180000.00,2,"Joseph");
        //
		Courses course3 = new Courses("3","NEET",90000.00,2,"Ramya");
		Courses course4 = new Courses("4","CAT",30000.00,1,"Kumar");
        //
		Courses course5 = new Courses("5","BANK_PO",50000.00,1,"Abhishek");
		Courses course6 = new Courses("6","BANK_SO",60000.00,3,"Pranav");
		//
		Courses course7 = new Courses("7","BANK_RRB",80000.00,2,"Sayantan");
		Courses course8 = new Courses("8","UPSC",70000.00,4,"Ram");
        //
		Courses course9 = new Courses("9","Clerk",10000.00,1,"Amey");
		Courses course10 = new Courses("10","SSC",20000.00,2,"Faiz");
        //
		Courses course11 = new Courses("11","BPSC",40000.00,2,"Raghu");
		Courses course12 = new Courses("12","TET",50000.00,3,"Vijay");
		//
		Courses course13 = new Courses("13","DRDO",200000.00,5,"Aman");
		Courses course14 = new Courses("14","Railways",300000.00,4,"Sethupathi");
		Courses course15 = new Courses("15","GATE",80000.00,2,"Sourav");
		
		//entering the course details to the array named courses
        List<Courses> courses = Arrays.asList(course1,course2,course3,course4,course5,course6,course7,course8,course9,course10,course11,course12,course13,course14,course15);
        return courses;
    }

}

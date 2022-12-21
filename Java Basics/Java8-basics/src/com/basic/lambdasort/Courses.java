package com.basic.lambdasort;

public class Courses {
	//declaring the attributes of course list
	private String course_id;
	private String course_name;
    private double total_fees;
    private int course_duration;
    private String course_teacher;
    
    //constructor for Courses
	public Courses(String course_id, String course_name, double total_fees, int course_duration,
			String course_teacher) {
		super();
		this.course_id = course_id;
		this.course_name = course_name;
		this.total_fees = total_fees;
		this.course_duration = course_duration;
		this.course_teacher = course_teacher;
	}

	//getter and setter methods
	public String getCourse_id() {
		return course_id;
	}

	public void setCourse_id(String course_id) {
		this.course_id = course_id;
	}

	public String getCourse_name() {
		return course_name;
	}

	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}

	public double getTotal_fees() {
		return total_fees;
	}

	public void setTotal_fees(double total_fees) {
		this.total_fees = total_fees;
	}

	public int getCourse_duration() {
		return course_duration;
	}

	public void setCourse_duration(int course_duration) {
		this.course_duration = course_duration;
	}

	public String getCourse_teacher() {
		return course_teacher;
	}

	public void setCourse_teacher(String course_teacher) {
		this.course_teacher = course_teacher;
	}

	//toString
	@Override
	public String toString() {
		return "\n"+"[course_id=" + course_id + ", course_name=" + course_name + ", total_fees=" + total_fees
				+ ", course_duration=" + course_duration + ", course_teacher=" + course_teacher + "]";
	}


}

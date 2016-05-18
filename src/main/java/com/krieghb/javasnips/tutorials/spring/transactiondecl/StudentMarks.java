package com.krieghb.javasnips.tutorials.spring.transactiondecl;

public class StudentMarks {
	
	private int age;
	private String name;
	private int id;
	private int marks;
	private int year;
	private int sid;
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public int getAge() {
		return age;
	}
	
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	
	
	public void setMarks(int marks) {
		this.marks = marks;
	}
	
	public int getMarks() {
		return marks;
	}
	
	
	public void setYear(int year) {
		this.year= year;
	}
	
	public int getYear() {
		return year;
	}
	
	
	public void setSid(int sid) {
		this.sid = sid;
	}
	
	public int getSid() {
		return sid;
	}
	
	
	public String printStudent() {
		String output = "ID : " + getId()
				+ ", Name:  " + getName()
				+ ", Marks:  " + getMarks()
				+ ", Year:  " + getYear()
				+ ", Age:  " + getAge()
				;
		
		return output;
	}

}

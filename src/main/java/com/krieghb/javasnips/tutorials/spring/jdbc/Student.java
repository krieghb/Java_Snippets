package com.krieghb.javasnips.tutorials.spring.jdbc;

public class Student {
	
	private Integer age;
	private String name;
	private Integer id;
	
	public Student() {
		
	}
	public Student(String name, Integer age) {
		setName(name);
		setAge(age);
	}
	
	
	public void setAge(Integer age) {
		this.age = age;
	}
	
	public Integer getAge() {
		return age;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getId() {
		return id;
	}

	
	public String printStudent() {
		String output = "ID:  " + getId()
				+ ", Name:  " +getName()
				+ ", Age:  " + getAge()
				+ "\n";
		
		return output;
		}
	
}

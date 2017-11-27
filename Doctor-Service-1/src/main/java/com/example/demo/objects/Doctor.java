package com.example.demo.objects;

public class Doctor {
	private int id;
	public int getId() {
		return id;
	}
	public Doctor(int id, String name, String address) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
	}
	
	public Doctor() {
		
	}
	public void setId(int id) {
		this.id = id;
	}
	private String name;
	private String address;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	

}

package com.example.demo.vo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Patient implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int patId;
	
	@Override
	public String toString() {
		return "Patient [patId=" + patId + ", fname=" + fname + ", lname=" + lname + ", userName=" + userName + "]";
	}

	private String fname;
	private String lname;
	
	private String userName;

	public int getPatId() {
		return patId;
	}

	public void setPatId(int patId) {
		this.patId = patId;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}

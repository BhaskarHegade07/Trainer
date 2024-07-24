package com.TrainerApp.DTO;

public class Student {

	private int sid;
	private String name;
	private long phone;
	private String mail;
	private String branch;
	private String location;
	private String password;
	public Student() {
		super();
	}
	public Student(int sid, String name, long phone, String mail, String branch, String location, String password) {
		super();
		this.sid = sid;
		this.name = name;
		this.phone = phone;
		this.mail = mail;
		this.branch = branch;
		this.location = location;
		this.password = password;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Student [sid=" + sid + ", name=" + name + ", phone=" + phone + ", mail=" + mail + ", branch=" + branch
				+ ", location=" + location + ", password=" + password + "]";
	}
	
}


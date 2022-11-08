package com.hostmm.hospital.admin.model;

import java.time.LocalDate;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Admin {
	private SimpleStringProperty adminID;
	private SimpleStringProperty username;
	private SimpleStringProperty password;
	private SimpleStringProperty name;
	private SimpleIntegerProperty age;
	private SimpleStringProperty nrc;
	private SimpleStringProperty phone;
	private SimpleStringProperty address;
	private SimpleStringProperty gender;
	private SimpleStringProperty birthDate;
	private SimpleDoubleProperty salary;
	private SimpleStringProperty startDate;
	private SimpleStringProperty resignDate;
	private SimpleStringProperty role;
	private SimpleStringProperty imageName;
	private SimpleBooleanProperty isActive;
	private SimpleBooleanProperty isSenior;
	
	public Admin(String adminID, String username, String password,String name, int age, String nrc, String phone, String address,
			String gender, LocalDate birthDate, double salary, LocalDate startDate, LocalDate resignDate,
			String role, String imageName, boolean isActive,boolean isSenior) {
		super();
		this.adminID = new SimpleStringProperty(adminID);
		this.username = new SimpleStringProperty(username);
		this.password = new SimpleStringProperty(password);
		this.name = new SimpleStringProperty(name);
		this.age = new SimpleIntegerProperty(age);
		this.nrc = new SimpleStringProperty(nrc);
		this.phone = new SimpleStringProperty(phone);
		this.address = new SimpleStringProperty(address);
		this.gender = new SimpleStringProperty(gender);
		this.birthDate = new SimpleStringProperty(birthDate.toString());
		this.salary = new SimpleDoubleProperty(salary);
		this.startDate = new SimpleStringProperty(startDate.toString());
		this.resignDate = new SimpleStringProperty(resignDate.toString());
		this.role = new SimpleStringProperty(role);
		this.imageName = new SimpleStringProperty(imageName);
		this.isActive = new SimpleBooleanProperty(isActive);
		this.isSenior = new SimpleBooleanProperty(isSenior);
	}
	
	public Admin(String adminID, String username, String password,String name, int age, String nrc, String phone, String address,
			String gender, LocalDate birthDate, double salary, LocalDate startDate,
			String role, String imageName, boolean isActive,boolean isSenior) {
		super();
		this.adminID = new SimpleStringProperty(adminID);
		this.username = new SimpleStringProperty(username);
		this.password = new SimpleStringProperty(password);
		this.name = new SimpleStringProperty(name);
		this.age = new SimpleIntegerProperty(age);
		this.nrc = new SimpleStringProperty(nrc);
		this.phone = new SimpleStringProperty(phone);
		this.address = new SimpleStringProperty(address);
		this.gender = new SimpleStringProperty(gender);
		this.birthDate = new SimpleStringProperty(birthDate.toString());
		this.salary = new SimpleDoubleProperty(salary);
		this.startDate = new SimpleStringProperty(startDate.toString());
		this.role = new SimpleStringProperty(role);
		this.imageName = new SimpleStringProperty(imageName);
		this.isActive = new SimpleBooleanProperty(isActive);
		this.isSenior = new SimpleBooleanProperty(isSenior);
	}
	
	public String getAdminID() {
		return adminID.get();
	}
	public void setAdminID(String adminID) {
		this.adminID = new SimpleStringProperty(adminID);
	}
	public String getUsername() {
		return username.get();
	}
	public void setUsername(String username) {
		this.username = new SimpleStringProperty(username);
	}
	public String getPassword() {
		return password.get();
	}
	public void setPassword(String password) {
		this.password = new SimpleStringProperty(password);
	}
	public int getAge() {
		return age.get();
	}
	public void setAge(int age) {
		this.age = new SimpleIntegerProperty(age);
	}
	public String getNrc() {
		return nrc.get();
	}
	public void setNrc(String nrc) {
		this.nrc = new SimpleStringProperty(nrc);
	}
	public String getPhone() {
		return phone.get();
	}
	public void setPhone(String phone) {
		this.phone = new SimpleStringProperty(phone);
	}
	public String getAddress() {
		return address.get();
	}
	public void setAddress(String address) {
		this.address = new SimpleStringProperty(address);
	}
	public String getGender() {
		return gender.get();
	}
	public void setGender(String gender) {
		this.gender = new SimpleStringProperty(gender);
	}
	public LocalDate getBirthDate() {
		LocalDate date = LocalDate.parse(this.birthDate.get());
		return date;
	}
	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = new SimpleStringProperty(birthDate.toString());
	}

	public double getSalary() {
		return salary.get();
	}
	public void setSalary(double salary) {
		this.salary = new SimpleDoubleProperty(salary);
	}
	public LocalDate getStartDate() {
		LocalDate date = LocalDate.parse(this.startDate.get());
		return date;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = new SimpleStringProperty(startDate.toString());
	}
	public LocalDate getResignDate() {
		LocalDate date = LocalDate.parse(this.resignDate.get());
		return date;
	}
	public void setResignDate(LocalDate resignDate) {
		this.resignDate = new SimpleStringProperty(resignDate.toString());
	}
	public String getRole() {
		return role.get();
	}
	public void setRole(String role) {
		this.role = new SimpleStringProperty(role);
	}
	public String getImageName() {
		return imageName.get();
	}
	public void setImageName(String imageName) {
		this.imageName = new SimpleStringProperty(imageName);
	}
	public boolean isActive() {
		return isActive.get();
	}
	public void setActive(boolean isActive) {
		this.isActive = new SimpleBooleanProperty(isActive);
	}
	
	public boolean isSenior() {
		return isSenior.get();
	}
	public void setSenior(boolean isSenior) {
		this.isSenior = new SimpleBooleanProperty(isSenior);
	}

	public String getName() {
		return name.get();
	}
	public void setName(String name) {
		this.name = new SimpleStringProperty(name);
	}
	
	
	
	

}

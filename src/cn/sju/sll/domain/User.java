package cn.sju.sll.domain;

import java.util.Date;

public class User {
	private String ID;
	private String Name;
	private Boolean Sex;
	private Date Birthday;
	private String PhoneNumber;
	private Integer Age;
	private String department;
	private String dorm;
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public Boolean getSex() {
		return Sex;
	}
	public void setSex(Boolean sex) {
		Sex = sex;
	}
	public Date getBirthday() {
		return Birthday;
	}
	public void setBirthday(Date birthday) {
		Birthday = birthday;
	}
	public String getPhoneNumber() {
		return PhoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		PhoneNumber = phoneNumber;
	}
	public Integer getAge() {
		return Age;
	}
	public void setAge(Integer age) {
		Age = age;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getDorm() {
		return dorm;
	}
	public void setDorm(String dorm) {
		this.dorm = dorm;
	}
	@Override
	public String toString() {
		return "User [ID=" + ID + ", Name=" + Name + ", Sex=" + Sex + ", Birthday=" + Birthday + ", PhoneNumber="
				+ PhoneNumber + ", Age=" + Age + ", department=" + department + ", dorm=" + dorm + "]";
	}

}

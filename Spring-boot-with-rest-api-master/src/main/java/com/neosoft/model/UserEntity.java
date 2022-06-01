package com.neosoft.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_details")
public class UserEntity {

	@Id
	@GeneratedValue
	private int userId;

	private String firstName;

	private String lastName;

	private String emailId;

	@Column(name = "date_of_birth")

	private String dob;

	@Column(name = "date_of_joining")
	private String joinDate;

	public UserEntity() {
		super();
	}

	public UserEntity(int userId, String firstName, String lastName, String emailId, String designation, String address,
			String dob, String joinDate, long contactNo, int pincode) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.dob = dob;
		this.joinDate = joinDate;

	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(String joinDate) {
		this.joinDate = joinDate;
	}

	@Override
	public String toString() {
		return "UserEntity [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", emailId="
				+ emailId + ", designation=" + ", address=" + ", dob=" + dob + ", joinDate=" + joinDate + ", contactNo="
				+ ", pincode=" + "]";
	}

}
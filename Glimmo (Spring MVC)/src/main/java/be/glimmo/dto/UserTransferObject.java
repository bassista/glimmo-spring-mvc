package be.glimmo.dto;

import java.sql.Date;

import be.glimmo.domain.enumeration.UserGrade;

public class UserTransferObject {
	private String username;
	private String email;
	private String firstName;
	private String lastName;
	private String password;
	private UserGrade grade;
	private Date gradeEnding;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserGrade getGrade() {
		return grade;
	}

	public void setGrade(UserGrade grade) {
		this.grade = grade;
	}

	public Date getGradeEnding() {
		return gradeEnding;
	}

	public void setGradeEnding(Date gradeEnding) {
		this.gradeEnding = gradeEnding;
	}
}

package be.glimmo.dto;

import java.sql.Date;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import be.glimmo.domain.enumeration.UserGrade;

public class UserTransferObject {
	
	@NotEmpty(message="{uto.notempty.username}")
	@Length(max=20)
	private String username;
	
	@NotEmpty(message="{uto.notempty.email}")
	@Email
	@Length(max=60)
	private String email;
	
	@Length(max=30)
	private String firstName;
	
	@NotEmpty(message="{uto.notempty.lastname}")
	@Length(max=30)
	private String lastName;
	
	@NotEmpty(message="{uto.notempty.password}")
	@Length(min=6, max=20, message="{uto.length.password}")
	private String password;
	
	private String passwordConfirmation;
	
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
	
	public String getPasswordConfirmation() {
		return passwordConfirmation;
	}
	
	public void setPasswordConfirmation(String passwordConfirmation) {
		this.passwordConfirmation = passwordConfirmation;
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

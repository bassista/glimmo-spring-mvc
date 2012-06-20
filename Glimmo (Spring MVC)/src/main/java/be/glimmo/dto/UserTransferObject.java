package be.glimmo.dto;

import java.sql.Date;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import be.glimmo.domain.enumeration.UserGrade;

public class UserTransferObject {
	private static final String PATTERN_EMAIL_VALIDATION="^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	
	@NotBlank
	@NotEmpty
	private String username;
	
	@NotBlank
	@NotEmpty
	@Email
//	@Pattern(regexp=PATTERN_EMAIL_VALIDATION)
	private String email;
	
	@NotBlank
	@NotEmpty
	private String firstName;
	
	@NotBlank
	@NotEmpty
	private String lastName;
	
	@NotBlank
	@NotEmpty
	private String password;
	
	@NotBlank
	@NotEmpty
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

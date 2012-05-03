package be.glimmo.domain;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import be.glimmo.util.Encrypter;

@Entity(name="Users")
@Table(name="USERS")
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="USER_ID", insertable=false, updatable=false)
	private long id;

	@Column(length=20, nullable=false, unique=true, updatable=false)
	private String username;
	
	@Column(length=60, nullable=false, unique=true)
	private String email;
	
	@Column(name="FIRST_NAME", length=30)
	private String firstName;
	
	@Column(name="LAST_NAME", length=30)
	private String lastName;
	
	@Column(length=16)
	private String password;
	
	@Column(nullable=false)
	private UserGrade grade;
	
	@Column(name="GRADE_ENDING", nullable=true)
	private Date gradeEnding;
	
	/* -------------------------- Constructors --------------------------- */
	
	public User(){}
	
	public User(String username){
		this.username = username;
	}
	
	public User(String username, String email, String firstName, String lastName) {
		super();
		this.username = username;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	/* ------------------------- GETTER + SETTER ------------------------- */
	public long getId() {
		return id;
	}

	public String getUsername() {
		return username;
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
	
	// Adding a convenience method within the setter in order to encrypt the password
	public void setPassword(String password) {
		this.password = Encrypter.encrypt(password);
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

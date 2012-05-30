package be.glimmo.domain;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import be.glimmo.domain.enumeration.UserGrade;
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
	
	private String password;
	
	@Column(nullable=false)
	private UserGrade grade;
	
	@Column(name="GRADE_ENDING", nullable=true)
	private Date gradeEnding;
	
	/* ---------------------- Mapped relationships ----------------------- */
	@OneToMany(cascade={CascadeType.ALL}, orphanRemoval=true, mappedBy="user", fetch=FetchType.LAZY)
	private List<Advertisement> ads = new ArrayList<Advertisement>();
	
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
	
	public List<Advertisement> getAds() {
		return ads;
	}
	
	/**
	 * Add the given advertisement to the current user's advertisement list. As the relationship between the ads and a user is bidirectional,
	 * this method will also establish the reciprocate relationship by setting the given advertisement's user as being the current user.
	 * @param ad
	 * @return boolean indicating whether the given ad has been correctly added
	 */
	public boolean addAd(Advertisement ad){
		if(ad == null){
			throw new IllegalArgumentException("cannot add NULL to a user's advertisement list");
		}
		
		ad.setUser(this);
		return this.ads.add(ad);
	}
	
	public boolean removeAdd(Advertisement ad){
		ad.setUser(null);
		return this.ads.remove(ad);
	}

	/* ------------------------- Hash / Equals ------------------------- */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((username == null) ? 0 : username.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}
}

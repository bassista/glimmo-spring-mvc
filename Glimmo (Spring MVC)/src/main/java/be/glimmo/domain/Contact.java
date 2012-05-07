package be.glimmo.domain;

import java.sql.Clob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.sql.rowset.serial.SerialClob;

@Entity(name="Contact")
@Table(name="CONTACT")
public class Contact {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="CONTACT_ID")
	private long id;

	@Column(name="EMAIL", nullable=true, length=60)
	private String email;

	@Column(name="TELEPHONE", nullable=true, length=15)
	private String phone;

	@Column(name="COMMENT", nullable=false, length=400)
	private Clob comment;

	/* -------------------------- Constructors --------------------------- */
	public Contact(){}

	/* ------------------------- GETTER + SETTER ------------------------- */
	public long getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Clob getComment() {
		return comment;
	}

	public void setComment(Clob comment) {
		this.comment = comment;
	}
	
	public void setCommentFromString(String comment){
		try {
			this.comment = new SerialClob(comment.toCharArray());
		} catch (Throwable t){
			throw new IllegalArgumentException("an error occurred when trying to set a String type comment to an instance of Contact", t);
		}
	}

	/* ------------------------- Hash / Equals ------------------------- */

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
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
		Contact other = (Contact) obj;
		if (id != other.id)
			return false;
		return true;
	}
}

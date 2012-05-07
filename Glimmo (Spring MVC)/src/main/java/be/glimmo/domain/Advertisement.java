package be.glimmo.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name="Ad")
@Table(name="ADVERTISEMENT")
public class Advertisement {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="AD_ID")
	private long id;
	
	@Column(name="ACTIVE", nullable=false)
	private boolean active;
	
	@Column(name="PUBLICATION_DATE", updatable=false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date publicationDate;
	
	@Column(name="DEADLINE")
	@Temporal(TemporalType.DATE)
	private Date deadline;
	
	/* ---------------------- Mapped relationships ----------------------- */
	@ManyToOne(fetch=FetchType.LAZY, optional=false)
	@JoinColumn(name="USER_ID")
	private User user;
	
	@OneToMany(fetch=FetchType.LAZY, orphanRemoval=true)
	private List<Contact> contacts = new ArrayList<Contact>();
	
	@OneToMany(fetch=FetchType.LAZY, orphanRemoval=true)
	private Set<Picture> pictures = new HashSet<Picture>();
	
	/* -------------------------- Constructors --------------------------- */
	public Advertisement(){}
	
	public Advertisement(boolean active, Date publicationDate, Date deadline){
		this.active = active;
		this.publicationDate = publicationDate;
		this.deadline = deadline;
	}
	
	/* ------------------------- GETTER + SETTER ------------------------- */
	public long getId() {
		return id;
	}

	public boolean isActive() {
		return active;
	}
	
	public void setActive(boolean active) {
		this.active = active;
	}
	
	public Date getPublicationDate() {
		return publicationDate;
	}
	
	public Date getDeadline() {
		return deadline;
	}
	
	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}
	
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	
	public List<Contact> getContacts() {
		return contacts;
	}
	
	public boolean addContact(Contact contact){
		if(contact == null){
			throw new IllegalArgumentException("cannot add NULL to the contact list");
		}
		
		return contacts.add(contact);
	}
	
	public boolean removeContact(Contact contact){
		return contacts.remove(contact);
	}
	
	public Set<Picture> getPictures() {
		return pictures;
	}
	
	public boolean addPicture(Picture picture){
		if(picture == null){
			throw new IllegalArgumentException("cannot add NULL to the picture list");
		}
		return this.pictures.add(picture);
	}
	
	public boolean removePicture(Picture picture){
		return this.pictures.remove(picture);
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
		Advertisement other = (Advertisement) obj;
		if (id != other.id)
			return false;
		return true;
	}
}

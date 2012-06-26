package be.glimmo.domain;

import java.sql.Clob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.sql.rowset.serial.SerialClob;

import be.glimmo.domain.enumeration.Language;

@Entity(name="Description")
@Table(name="DESCRIPTION")
public class Description {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="DESCRIPTION_ID")
	private long id;
	
	@Column(name="LANGUAGE", updatable=false, nullable=false)
	@Enumerated(EnumType.STRING)
	private Language language;
	
	@Column(name="DESCRIPTION", nullable=false, length=1000)
	private Clob description;
	
	/* -------------------------- Constructors --------------------------- */
	public Description(){}
	
	public Description(Language language){
		this.language = language;
	}
	
	public Description(Language language, Clob description){
		this.language = language;
		this.description = description;
	}
	
	/* ------------------------- GETTER + SETTER ------------------------- */
	public long getId() {
		return id;
	}
	
	public Language getLanguage() {
		return language;
	}
	
	public Clob getDescription() {
		return description;
	}
	
	public void setDescription(Clob description) {
		this.description = description;
	}
	
	public void setDescriptionAsString(String description) {
		try {
			this.description = new SerialClob(description.toCharArray());
		} catch (Throwable t) {
			throw new IllegalArgumentException("an error occurred when setting a String description to a good", t);
		} 
	}

	/* -------------------------- Hash / Equals -------------------------- */
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
		Description other = (Description) obj;
		if (id != other.id)
			return false;
		return true;
	}
}

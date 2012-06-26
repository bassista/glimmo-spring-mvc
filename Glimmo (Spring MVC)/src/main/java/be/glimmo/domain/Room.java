package be.glimmo.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import be.glimmo.domain.enumeration.Language;
import be.glimmo.domain.enumeration.RoomType;

@Entity(name="Room")
@Table(name="ROOM")
public class Room {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ROOM_ID")
	private long id;

	@Column(name="TYPE", nullable=false)
	@Enumerated(EnumType.STRING)
	private RoomType type;

	@Column(name="DIMENSION", nullable=false, precision=2)
	private Double dimension;
	
	/* ---------------------- Mapped relationships ----------------------- */
	@OneToMany(cascade=CascadeType.ALL, orphanRemoval=true)
	private Set<Description> descriptions = new HashSet<Description>(); 

	/* -------------------------- Constructors --------------------------- */
	public Room(){}

	public Room(RoomType type, Double dimension){
		this.type = type;
		this.dimension = dimension;
	}

	/* ------------------------- GETTER + SETTER ------------------------- */
	public long getId() {
		return id;
	}

	public RoomType getType() {
		return type;
	}

	public void setType(RoomType type) {
		this.type = type;
	}

	public Double getDimension() {
		return dimension;
	}

	public void setDimension(Double dimension) {
		this.dimension = dimension;
	}

	public Set<Description> getDescriptions() {
		return descriptions;
	}
	
	public boolean addDescription(Description description){
		return this.descriptions.add(description);
	}
	
	public Description getDescriptionForLanguage(Language language){
		for(Description desc : descriptions){
			if(desc.getLanguage().equals(language)){
				return desc;
			}
		}
		
		return null;
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
		Room other = (Room) obj;
		if (id != other.id)
			return false;
		return true;
	}
}

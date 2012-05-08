package be.glimmo.domain;

import java.sql.Clob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import be.glimmo.domain.enumeration.RoomType;

@Entity(name="Room")
@Table(name="ROOM")
public class Room {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ROOM_ID")
	private long id;

	@Column(name="TYPE", nullable=false)
	private RoomType type;

	@Column(name="DIMENSION", nullable=false, precision=2)
	private Double dimension;

	@Column(name="DESCRIPTION", length=200)
	private Clob description;

	/* -------------------------- Constructors --------------------------- */
	public Room(){}

	public Room(RoomType type, Double dimension, Clob description){
		this.type = type;
		this.dimension = dimension;
		this.description = description;
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

	public Clob getDescription() {
		return description;
	}

	public void setDescription(Clob description) {
		this.description = description;
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

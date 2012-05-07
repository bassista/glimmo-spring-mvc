package be.glimmo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="Picture")
@Table(name="PICTURE")
public class Picture {
	@Id
	@Column(name="FILENAME")
	private String filename;
	
	@Column(name="WIDTH", nullable=false)
	private Integer width;
	
	@Column(name="HEIGHT", nullable=false)
	private Integer height;
	
	/* -------------------------- Constructors --------------------------- */
	public Picture(){}
	
	public Picture(String filename, Integer width, Integer height){
		this.filename = filename;
		this.width = width;
		this.height = height;
	}
	
	/* ------------------------- GETTER + SETTER ------------------------- */
	public String getFilename() {
		return filename;
	}
	
	public void setFilename(String filename) {
		this.filename = filename;
	}
	
	public Integer getWidth() {
		return width;
	}
	
	public Integer getHeight() {
		return height;
	}

	/* ------------------------- Hash / Equals ------------------------- */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((filename == null) ? 0 : filename.hashCode());
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
		Picture other = (Picture) obj;
		if (filename == null) {
			if (other.filename != null)
				return false;
		} else if (!filename.equals(other.filename))
			return false;
		return true;
	}
}

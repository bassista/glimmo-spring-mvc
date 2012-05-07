package be.glimmo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity(name="Land")
@Table(name="LAND")
public class Land extends Good{
	@Column(name="BUILD_LICENCE", nullable=false)
	private boolean licenseToBuild;
	
	/* -------------------------- Constructors --------------------------- */
	public Land(){}
	
	public Land(boolean licenceToBuild){
		this.licenseToBuild = licenceToBuild;
	}
	
	/* ------------------------- GETTER + SETTER ------------------------- */
	public boolean hasLicenseToBuild(){
		return licenseToBuild;
	}
	
	public void setLicenseToBuild(boolean licenseToBuild) {
		this.licenseToBuild = licenseToBuild;
	}
}

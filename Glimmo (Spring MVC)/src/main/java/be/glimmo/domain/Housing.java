package be.glimmo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity(name="HOUSING")
public abstract class Housing extends Good{
	@Column(name="LIVING_AREA", precision=2)
	private Double livingArea;
	
	@Column(name="NB_BEDROOMS", nullable=false)
	private Integer nbBedrooms;
	
	@Column(name="NB_PARKING_IN")
	private Integer nbIndoorParking;
	
	@Column(name="NB_PARKING_OUT")
	private Integer nbOutdoorParking;
	
	@Column(name="NB_WC")
	private Integer nbWc;
	
	@Column(name="NB_BATHROOM")
	private Integer nbBathroom;
	
	@Column(name="NB_STORY")
	private Integer nbStory;
	
	@Column(name="LIFT")
	private boolean lift;
	
	@Column(name="HEATING_TYPE")
	private HeatingType heatingType;
	
	@Column(name="YARD")
	private boolean yard;
	
	@Column(name="ATTIC")
	private boolean attic;
	
	@Column(name="CELLAR")
	private boolean cellar;

	/* ------------------------- GETTER + SETTER ------------------------- */
	public Double getLivingArea() {
		return livingArea;
	}

	public void setLivingArea(Double livingArea) {
		this.livingArea = livingArea;
	}

	public Integer getNbBedrooms() {
		return nbBedrooms;
	}

	public void setNbBedrooms(Integer nbBedrooms) {
		this.nbBedrooms = nbBedrooms;
	}

	public Integer getNbIndoorParking() {
		return nbIndoorParking;
	}

	public void setNbIndoorParking(Integer nbIndoorParking) {
		this.nbIndoorParking = nbIndoorParking;
	}

	public Integer getNbOutdoorParking() {
		return nbOutdoorParking;
	}

	public void setNbOutdoorParking(Integer nbOutdoorParking) {
		this.nbOutdoorParking = nbOutdoorParking;
	}

	public Integer getNbWc() {
		return nbWc;
	}

	public void setNbWc(Integer nbWc) {
		this.nbWc = nbWc;
	}

	public Integer getNbBathroom() {
		return nbBathroom;
	}

	public void setNbBathroom(Integer nbBathroom) {
		this.nbBathroom = nbBathroom;
	}

	public Integer getNbStory() {
		return nbStory;
	}

	public void setNbStory(Integer nbStory) {
		this.nbStory = nbStory;
	}

	public boolean hasLift() {
		return lift;
	}

	public void setLift(boolean lift) {
		this.lift = lift;
	}

	public HeatingType getHeatingType() {
		return heatingType;
	}

	public void setHeatingType(HeatingType heatingType) {
		this.heatingType = heatingType;
	}

	public boolean hasYard() {
		return yard;
	}

	public void setYard(boolean yard) {
		this.yard = yard;
	}
	
	public boolean hasAttic() {
		return attic;
	}
	
	public void setAttic(boolean attic) {
		this.attic = attic;
	}
	
	public boolean hasCellar() {
		return cellar;
	}
	
	public void setCellar(boolean cellar) {
		this.cellar = cellar;
	}
}

package be.glimmo.dto;

import java.io.Serializable;

public class LandDescriptionTransferObject extends GoodDescriptionTransferObject implements Serializable{
	private static final long serialVersionUID = -1656938257227927828L;
	
	private boolean licenceToBuild;
	
	public boolean getLicenceToBuild() { // has to be getXXX (not hasXXX) to comply with Spring Expression Language accessor
		return licenceToBuild;
	}
	
	public void setLicenceToBuild(boolean licenceToBuild) {
		this.licenceToBuild = licenceToBuild;
	}
}

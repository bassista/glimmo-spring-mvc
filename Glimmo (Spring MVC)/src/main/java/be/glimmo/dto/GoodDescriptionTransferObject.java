package be.glimmo.dto;

import java.io.Serializable;

public abstract class GoodDescriptionTransferObject implements Serializable{
	private static final long serialVersionUID = 6119772595649395718L;

	private Integer groundSurface;
	private Double price;
	
	public Integer getGroundSurface() {
		return groundSurface;
	}
	
	public void setGroundSurface(Integer groundSurface) {
		this.groundSurface = groundSurface;
	}
	
	public Double getPrice() {
		return price;
	}
	
	public void setPrice(Double price) {
		this.price = price;
	}
}

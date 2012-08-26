package be.glimmo.dto;

import java.io.Serializable;

public abstract class GoodDescriptionTransferObject implements Serializable{
	private static final long serialVersionUID = 6119772595649395718L;

	private Double price;
	
	public Double getPrice() {
		return price;
	}
	
	public void setPrice(Double price) {
		this.price = price;
	}
}

package be.glimmo.domain;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity(name="Appartment")
@Table(name="APPARTMENT")
public class Appartment extends Housing{

	@Column(name="COMMON_CHARGES", precision=2)
	private BigDecimal commonCharges;

	@Column(name="PRICE_PARKING_IN", precision=2)
	private BigDecimal priceIndoorParking;

	@Column(name="PRICE_PARKING_OUT", precision=2)
	private BigDecimal priceOutdoorParking;

	@Column(name="STORY", nullable=false)
	private String story;

	@Column(name="CHARGES", precision=2)
	public BigDecimal getCommonCharges() {
		return commonCharges;
	}

	/* ------------------------- GETTER + SETTER ------------------------- */
	public void setCommonCharges(BigDecimal commonCharges) {
		this.commonCharges = commonCharges;
	}

	public BigDecimal getPriceIndoorParking() {
		return priceIndoorParking;
	}

	public void setPriceIndoorParking(BigDecimal priceIndoorParking) {
		this.priceIndoorParking = priceIndoorParking;
	}

	public BigDecimal getPriceOutdoorParking() {
		return priceOutdoorParking;
	}

	public void setPriceOutdoorParking(BigDecimal priceOutdoorParking) {
		this.priceOutdoorParking = priceOutdoorParking;
	}

	public String getStory() {
		return story;
	}

	public void setStory(String story) {
		this.story = story;
	}

}

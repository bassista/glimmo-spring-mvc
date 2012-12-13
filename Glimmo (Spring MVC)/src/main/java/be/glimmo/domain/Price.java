package be.glimmo.domain;


import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name="Price")
@Table(name="PRICE")
public class Price implements Comparable<Price>{
	@Id
	@Column(name="START_VALIDITY", nullable=false, updatable=false)
	@Temporal(TemporalType.DATE)
	private Date startValidity; 

	@Column(name="PRICE", nullable=false, updatable=false)
	private BigDecimal price;

	/* -------------------------- Constructors --------------------------- */
	public Price(){}

	public Price(Date startValidity, BigDecimal price){
		this.startValidity = startValidity;
		this.price = price;
	}

	/* ------------------------- GETTER + SETTER ------------------------- */
	public Date getStartValidity() {
		return startValidity;
	}

	public BigDecimal getPrice() {
		return price;
	}

	/* -------------------------- Hash / Equals -------------------------- */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
		+ ((startValidity == null) ? 0 : startValidity.hashCode());
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
		Price other = (Price) obj;
		if (startValidity == null) {
			if (other.startValidity != null)
				return false;
		} else if (!startValidity.equals(other.startValidity))
			return false;
		return true;
	}

	public int compareTo(Price o) {
		return this.startValidity.compareTo(o.getStartValidity());
	}
}

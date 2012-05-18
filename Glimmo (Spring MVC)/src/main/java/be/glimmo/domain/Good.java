
package be.glimmo.domain;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import be.glimmo.domain.enumeration.Language;

@Entity(name="GOOD")
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public abstract class Good {
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	@Column(name="GOOD_ID")
	private Long id = null;
	
	@Column(name="SURFACE", scale=2)
	private Double surface;
	
	// embedded attribute
	private Location location;
	
	/* ---------------------- Mapped relationships ----------------------- */
	@OneToMany(cascade={CascadeType.ALL}, orphanRemoval=true, fetch=FetchType.EAGER)
	private Set<Price> priceHistory = new TreeSet<Price>();
	
	@OneToOne(fetch=FetchType.LAZY, mappedBy="good")
	private Advertisement ad;
	
	@OneToMany(cascade=CascadeType.ALL, orphanRemoval=true)
	private Set<Description> descriptions = new HashSet<Description>(); 
	
	/* ------------------------- GETTER + SETTER ------------------------- */
	public long getId() {
		return id;
	}
	
	public Double getSurface() {
		return surface;
	}
	
	public void setSurface(Double surface) {
		this.surface = surface;
	}
	
	public Set<Price> getPriceHistory() {
		return priceHistory;
	}
	
	public boolean addPrice(Price price){
		if(price == null){
			throw new IllegalArgumentException("cannot add NULL to a good's price list");
		}
		
		return this.priceHistory.add(price);
	}
	
	public Location getLocation() {
		return location;
	}
	
	public void setLocation(Location location) {
		this.location = location;
	}
	
	public Advertisement getAd() {
		return ad;
	}
	
	public void setAd(Advertisement ad) {
		this.ad = ad;
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
	
	/* ----------------------- Convenience methods ----------------------- */
	public BigDecimal getCurrentPrice(){
		Iterator<Price> priceIt = priceHistory.iterator();
		Price currentPrice = priceIt.next();
		Date currentDate = new Date();

		while(priceIt.hasNext()){
			Price price = priceIt.next();
			
			if(price.getStartValidity().after(currentDate)){
				break;
			}
			
			currentPrice = price;
		}
		
		return currentPrice.getPrice();
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
		Good other = (Good) obj;
		if (id != other.id)
			return false;
		return true;
	}
}

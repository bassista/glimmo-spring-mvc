package be.glimmo.dto;

import java.io.Serializable;
import java.util.Date;

import be.glimmo.domain.enumeration.AdvertisementType;

public class AdvertisementTransferObject implements Serializable{
	private static final long serialVersionUID = -1281728131762610354L;
	
	private Date publicationDate;
	private Date deadline;
	private AdvertisementType adType;
	
	public Date getPublicationDate() {
		return publicationDate;
	}
	
	public void setPublicationDate(Date publicationDate) {
		this.publicationDate = publicationDate;
	}
	
	public Date getDeadline() {
		return deadline;
	}
	
	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}
	
	public AdvertisementType getAdType() {
		return adType;
	}
	
	public void setAdType(AdvertisementType adType) {
		this.adType = adType;
	}
}

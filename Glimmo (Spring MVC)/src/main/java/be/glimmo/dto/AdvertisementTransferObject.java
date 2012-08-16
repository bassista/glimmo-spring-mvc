package be.glimmo.dto;

import java.io.Serializable;
import java.util.Date;

import org.springframework.binding.message.MessageBuilder;
import org.springframework.binding.message.MessageContext;
import org.springframework.binding.message.MessageResolver;
import org.springframework.binding.validation.ValidationContext;

import be.glimmo.domain.enumeration.AdvertisementType;

public class AdvertisementTransferObject implements Serializable{
	
	enum GoodType{
		LAND, APPARTMENT, HOUSE				
	}
	
	private static final long serialVersionUID = -1281728131762610354L;
	
	private Date publicationDate;
	private Date deadline;
	private AdvertisementType adType;
	private GoodType goodType;
	private String descriptionFr;
	private String descriptionNl;
	private String descriptionEn;	
	
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
	
	public GoodType getGoodType() {
		return goodType;
	}
	
	public void setGoodType(GoodType goodType) {
		this.goodType = goodType;
	}
	
	public String getDescriptionFr() {
		return descriptionFr;
	}
	
	public void setDescriptionFr(String descriptionFr) {
		this.descriptionFr = descriptionFr;
	}
	
	public String getDescriptionNl() {
		return descriptionNl;
	}
	
	public void setDescriptionNl(String descriptionNl) {
		this.descriptionNl = descriptionNl;
	}
	
	public String getDescriptionEn() {
		return descriptionEn;
	}
	
	public void setDescriptionEn(String descriptionEn) {
		this.descriptionEn = descriptionEn;
	}
	
	/* ------------------------- Validation method ------------------------- */
	public void validateCreateAd(ValidationContext context){
		MessageContext messages = context.getMessageContext();
				
		checkValueSelection(messages);
		checkAdvertisementDates(messages);
		
		messages.getAllMessages();
	}
	
	private void checkValueSelection(MessageContext messages){
		if(this.adType == null){
			MessageResolver adTypeError = new MessageBuilder().error().source("adType").defaultText("A value must be selected").build();
			messages.addMessage(adTypeError);
		}
		
		if(this.goodType == null){
			MessageResolver adTypeError = new MessageBuilder().error().source("goodType").defaultText("A value must be selected").build();
			messages.addMessage(adTypeError);
		}
	}
	
	private void checkAdvertisementDates(MessageContext messages){
		if(this.publicationDate == null){
			MessageResolver publicationDateError = new MessageBuilder().error().source("publicationDate").defaultText("A publication date must be defined").build();
			messages.addMessage(publicationDateError);
		}
		
		if(this.deadline == null){
			MessageResolver deadlineError = new MessageBuilder().error().source("deadline").defaultText("An expiration date must be defined").build();
			messages.addMessage(deadlineError);
		}
		
		if(publicationDate != null && deadline != null && this.deadline.before(publicationDate)){
			MessageResolver adDatesError = new MessageBuilder().error().source("deadline").defaultText("The deadline cannot be anterior to the publication date").build();
			messages.addMessage(adDatesError);
		}
	}
}

package be.glimmo.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;

import org.springframework.binding.message.MessageBuilder;
import org.springframework.binding.message.MessageContext;
import org.springframework.binding.message.MessageResolver;
import org.springframework.binding.validation.ValidationContext;

import be.glimmo.domain.enumeration.AdvertisementType;

public class AdvertisementTransferObject implements Serializable{
	
	public static enum GoodType{
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
	private String street;
	private String number;
	private String zipCode;
	private String city;
	private String country;
	
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
	
	public String getStreet() {
		return street;
	}
	
	public void setStreet(String street) {
		this.street = street;
	}
	
	public String getNumber() {
		return number;
	}
	
	public void setNumber(String number) {
		this.number = number;
	}
	
	public String getZipCode() {
		return zipCode;
	}
	
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getCountry() {
		return country;
	}
	
	public void setCountry(String country) {
		this.country = country;
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

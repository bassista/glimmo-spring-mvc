package be.glimmo.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.sql.rowset.serial.SerialClob;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import be.glimmo.dao.AdvertisementDao;
import be.glimmo.domain.Advertisement;
import be.glimmo.domain.Description;
import be.glimmo.domain.Land;
import be.glimmo.domain.Location;
import be.glimmo.domain.Price;
import be.glimmo.domain.User;
import be.glimmo.domain.enumeration.Language;
import be.glimmo.dto.AdvertisementTransferObject;
import be.glimmo.dto.LandDescriptionTransferObject;

@Service("advertisementService")
public class AdvertisementServiceImpl implements AdvertisementService{
	@Autowired
	private UserService userService;
	
	@Autowired
	private AdvertisementDao advertisementDao;		
	
	@Transactional(readOnly=true, propagation=Propagation.SUPPORTS)
	public List<Advertisement> listAllAdvertisements() {
		List<Advertisement> list = advertisementDao.findAll();
		return list;
	}

	@Transactional(propagation=Propagation.REQUIRED)
	@PreAuthorize("isAuthenticated()")
	public boolean persistAdvertisement(AdvertisementTransferObject adDto, LandDescriptionTransferObject landDescDto) {
		User ownerUser = getOwnerUser();
		Advertisement ad = convertToEntity(adDto);
		ad.setUser(ownerUser);
		
		Location address = new Location(adDto.getStreet(), adDto.getNumber(), adDto.getZipCode(), adDto.getCity(), adDto.getCity());
		
		if(adDto.getGoodType().equals(AdvertisementTransferObject.GoodType.LAND)){
			Land land = new Land();
			land.setAd(ad);
			land.setLicenseToBuild(landDescDto.getLicenceToBuild());
			land.setLocation(address);
			land.setSurface(landDescDto.getGroundSurface());
			
			List<Description> descriptions;
			descriptions = extractDescriptions(adDto);
			
			for(Description desc : descriptions){
				land.addDescription(desc);
			}
		
			ad.setGood(land);			
		}
		
		// TODO: else if other type
		// END todo
		
		Price initialPrice = new Price(ad.getPublicationDate(), new BigDecimal(landDescDto.getPrice().toString()));
		ad.getGood().addPrice(initialPrice);
		advertisementDao.save(ad);
		return false;
	}

	/* ---------------------- Convenience methods ----------------------- */
	private Advertisement convertToEntity(AdvertisementTransferObject adDto){
		Advertisement ad = new Advertisement(true, adDto.getPublicationDate(), adDto.getDeadline(), adDto.getAdType());
		return ad;
	}
	
	/**
	 * Retrieves the user who is the owner of the current advertisement
	 * @return
	 */
	private User getOwnerUser(){
		SecurityContext securityCtx = SecurityContextHolder.getContext();
		String currentUsername = securityCtx.getAuthentication().getName();
		User currentUser = userService.findUserByUsername(currentUsername);
		return currentUser;
	}
	
	private List<Description> extractDescriptions(AdvertisementTransferObject adDto){
		List<Description> descriptions = new ArrayList<Description>();

		try{
			Description descFrench = new Description(Language.FRENCH, new SerialClob(adDto.getDescriptionFr().toCharArray()));
			descriptions.add(descFrench);
			Description descDutch = new Description(Language.DUTCH, new SerialClob(adDto.getDescriptionNl().toCharArray()));
			descriptions.add(descDutch);
			Description descEnglish = new Description(Language.ENGLISH, new SerialClob(adDto.getDescriptionEn().toCharArray()));
			descriptions.add(descEnglish);
		}catch(Throwable t){
			// TODO log empty descriptions
		}

		return descriptions;
	}
}

package be.glimmo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import be.glimmo.dao.AdvertisementDao;
import be.glimmo.domain.Advertisement;
import be.glimmo.domain.Land;
import be.glimmo.domain.Location;
import be.glimmo.domain.User;
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
		SecurityContext securityCtx = SecurityContextHolder.getContext();
		String currentUsername = securityCtx.getAuthentication().getName();
		User currentUser = userService.findUserByUsername(currentUsername);
		
		Advertisement ad = convertToEntity(adDto);
		ad.setUser(currentUser);
		Location address = new Location(adDto.getStreet(), adDto.getNumber(), adDto.getZipCode(), adDto.getCity(), adDto.getCity());
		
		if(adDto.getGoodType().equals(AdvertisementTransferObject.GoodType.LAND)){
			Land land = new Land();
			land.setAd(ad);
			land.setLicenseToBuild(landDescDto.hasLicenceToBuild());
			land.setLocation(address);
			land.setSurface(landDescDto.getGroundSurface());
			ad.setGood(land);
		}
		
		// TODO: else if other type
		
		advertisementDao.save(ad);
		return false;
	}

	/* ---------------------- Convenience methods ----------------------- */
	private Advertisement convertToEntity(AdvertisementTransferObject adDto){
		Advertisement ad = new Advertisement(true, adDto.getPublicationDate(), adDto.getDeadline(), adDto.getAdType());
		return ad;
	}
}

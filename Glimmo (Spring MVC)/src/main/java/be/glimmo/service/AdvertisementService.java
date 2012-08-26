package be.glimmo.service;

import java.util.List;

import be.glimmo.domain.Advertisement;
import be.glimmo.dto.AdvertisementTransferObject;
import be.glimmo.dto.LandDescriptionTransferObject;

public interface AdvertisementService {
	public List<Advertisement> listAllAdvertisements();
	public boolean persistAdvertisement(AdvertisementTransferObject adDto, LandDescriptionTransferObject landDescDto);
}

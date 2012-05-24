package be.glimmo.dao;

import java.util.List;

import be.glimmo.domain.Advertisement;
import be.glimmo.domain.Good;
import be.glimmo.domain.enumeration.AdvertisementType;

public interface AdvertisementDao extends GenericDao<Advertisement, Long>{
	/**
	 * Retrieves advertisements based on their type {@link AdvertisementType}
	 * @param advertisementType
	 * @return
	 */
	public List<Advertisement> listAdvertisementByType(AdvertisementType advertisementType);
	
	/**
	 * Retrieves advertisements based on their type {@link AdvertisementType} and their status (active/inactive)
	 * @param advertisementType
	 * @param isActive
	 * @return
	 */
	public List<Advertisement> listAdvertisementByType(AdvertisementType advertisementType, boolean isActive);
	
	/**
	 * Retrieves advertisements based on their type {@link AdvertisementType}, and the type of the good they're related to 
	 * (HOUSE/APPARTMENT/LAND)
	 * @param advertisementType
	 * @param type
	 * @return
	 */
	public List<Advertisement> listAdvertisementByType(AdvertisementType advertisementType, Class<? extends Good> type);
}

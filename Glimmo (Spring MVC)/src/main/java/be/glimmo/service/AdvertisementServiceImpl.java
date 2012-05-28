package be.glimmo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import be.glimmo.dao.AdvertisementDao;
import be.glimmo.domain.Advertisement;

@Service
public class AdvertisementServiceImpl implements AdvertisementService{
	@Autowired
	private AdvertisementDao advertisementDao;
	
	@Transactional(readOnly=true, propagation=Propagation.SUPPORTS)
	public List<Advertisement> listAllAdvertisements() {
		List<Advertisement> list = advertisementDao.findAll();
		return list;
	}

}

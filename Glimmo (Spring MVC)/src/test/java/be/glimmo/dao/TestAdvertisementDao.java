package be.glimmo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.Test;

import be.glimmo.domain.Advertisement;

@ContextConfiguration(locations="classpath:GlimmoHome-servlet.xml")
@Test
public class TestAdvertisementDao extends AbstractTestNGSpringContextTests{
	@Autowired
	private AdvertisementDao advertisementDao;
	
//	@BeforeSuite()
//	public void loadDBDriver(){
//		System.out.println("pouet");
//	}
	
	public void testListAll(){
		List<Advertisement> ads = advertisementDao.findAll();
		Assert.assertEquals(ads.size(), 0);
	}
	
}

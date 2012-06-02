package be.glimmo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.springframework.transaction.annotation.Transactional;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import be.glimmo.domain.User;
import be.glimmo.domain.enumeration.UserGrade;

@Test
@ContextConfiguration(locations={"classpath:Glimmo-context-test-configuration.xml", 
								 "classpath:Glimmo-persistence-test-configuration.xml"})
public class TestUserDao extends AbstractTransactionalTestNGSpringContextTests{
	private static final String USER_TABLENAME = "USERS";
	
	@Autowired
	private UserDao userDao;
	
	@BeforeClass
	@Transactional
	public void emptyTable(){
		deleteFromTables(USER_TABLENAME);
	}
	
	@Test
	@Rollback(false)
	public void testUserCreation() {
		User newUser = new User("user1", "user1@gmail.com", "firstname", "lastName");
		newUser.setGrade(UserGrade.BASIC);
		newUser.setPassword("secr3t");
		userDao.save(newUser);
		
		int rowCount = countRowsInTable(USER_TABLENAME);
		Assert.assertEquals(rowCount, 1);
	}
}

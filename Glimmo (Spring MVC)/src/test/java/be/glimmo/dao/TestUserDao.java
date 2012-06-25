package be.glimmo.dao;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.converters.SqlDateConverter;
import org.apache.commons.lang3.RandomStringUtils;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import be.glimmo.domain.User;
import be.glimmo.domain.enumeration.UserGrade;

@Test
@ContextConfiguration(locations={"classpath:Glimmo-context-test-configuration.xml", 
								 "classpath:Glimmo-persistence-test-configuration.xml"})
public class TestUserDao extends AbstractTransactionalTestNGSpringContextTests{
	private static final String USER_TABLENAME = "USERS";
	
	private SqlDateConverter sqlDateConverter = new SqlDateConverter();
	
	/* -------------------------- Data Providers --------------------------- */
	Object[][] users = new Object[][]{
			new Object []{"mairj23", "michael.jordan@bulls.com", "Michael", "Jordan", 
							UserGrade.PREMIUM, "ilovebulls", sqlDateConverter.convert(Date.class, "2012-12-31")},
			new Object []{"kb24", "kobe.bryant@lakers.com", "Kobe", "Bryant", 
					UserGrade.PREMIUM, "ilovelakers", sqlDateConverter.convert(Date.class, "2012-12-30")},
			new Object []{"dr01", "derrick.rose@bulls.com", "Derrick", "Rose", 
					UserGrade.BASIC, "ilovebulls", sqlDateConverter.convert(Date.class, "2013-12-31")},
			new Object []{"tp09", "tony.parker@spurs.com", null, null, 
					UserGrade.BASIC, "ilovespurs", null},
			new Object []{"dstern", "david.stern@nba.com", null, null, 
					UserGrade.ADMIN, "ilovespurs", null}
	};
	
	@DataProvider(name="usersProvider")
	public Object[][] provideUsersForCreation(){
		return users;
	}
	
	private int cptUser = 0;
	
	@Autowired
	private UserDao userDao;
	
	@Test(dataProvider="usersProvider")
	@Rollback(false)
	public void testUserCreation(String username, String email, String firstName, String lastName, UserGrade userGrade, String password, Date gradeEnd) {
		User newUser = new User(username, email, firstName, lastName);
		newUser.setGrade(userGrade);
		newUser.setPassword(password);
		userDao.save(newUser);
		
		int rowCount = countRowsInTable(USER_TABLENAME);
		Assert.assertEquals(rowCount, ++cptUser);
	}
	
	@Test(dependsOnMethods={"testUserCreation"})
	public void testCount(){
		long nbRow = userDao.countAll();
		Assert.assertEquals(nbRow, (long) cptUser);
	}
	
	@Test(dependsOnMethods={"testUserCreation"})
	public void testFindUserById(){
		User user = userDao.findById(1L);
		Assert.assertNotNull(user);
		Assert.assertEquals(user.getUsername(), users[0][0]);
	}
	
	@Test(dependsOnMethods={"testUserCreation"})
	public void testAllUsersRetrieval(){
		List<User> allUsers = userDao.findAll();
		Assert.assertEquals(allUsers.size(), cptUser);
		
		// Construction of the user collection based upon the data provider, in order to assert through collection comparison
		List<User> providedUsers = new ArrayList<User>();
		for(int i=0; i<users.length; i++){
			User user = new User((String)users[i][0], (String)users[i][1], (String)users[i][2], (String)users[i][3]);
			providedUsers.add(user);
		}
		
		Assert.assertEquals(allUsers, providedUsers);
	}
	
	@Test(dependsOnMethods={"testFindUserById"})
	public void testUserModification(){
		Long userId = 1L;
		User user = userDao.findById(userId);
		Assert.assertNotNull(user);
		
		String randomString = RandomStringUtils.randomAlphabetic(14);
		user.setLastName(randomString);
		userDao.saveOrUpdate(user);
		user = userDao.findById(userId);
		Assert.assertNotNull(user);
		
		Assert.assertEquals(user.getLastName(), randomString);
	}
	
	@Test(dependsOnMethods={"testUserModification"})
	public void testUserDeletion(){
		long userId = 1L;
		User user = userDao.findById(userId);
		Assert.assertNotNull(user);
		
		userDao.delete(user);
		user = userDao.findById(userId);
		Assert.assertNull(user);
	}
	
	@Test(dependsOnMethods={"testUserModification"})
	public void testDeletionById(){
		Long userId = 2L;
		User user = userDao.findById(userId);
		Assert.assertNotNull(user);
		
		userDao.delete(userId);
		user = userDao.findById(userId);
		Assert.assertNull(user);
	}
	
	@Test(dependsOnMethods={"testDeletionById"})
	public void testSelectionByCriteria(){
		Criteria criteria = userDao.createCriteria();
		criteria.add(Restrictions.eq("firstName", "Kobe"));
		List<User> users = userDao.executeCriteria(criteria);
		Assert.assertNotNull(users);
		Assert.assertEquals(users.size(), 1);
		User foundUser = users.get(0);
		Assert.assertEquals(foundUser.getLastName(), "Bryant");
	}
}

package be.glimmo.service;

import java.sql.Date;
import java.text.ParseException;

import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import be.glimmo.dao.UserDao;
import be.glimmo.domain.User;
import be.glimmo.domain.enumeration.UserGrade;
import be.glimmo.dto.UserTransferObject;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;
	
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void createUser(String username, String email, String firstname, String lastname, String password) {
		User user = new User(username, email, firstname, lastname);
		user.setPassword(password);
		user.setGrade(UserGrade.BASIC);
		
		try {
			user.setGradeEnding(new Date(DateUtils.parseDate("31/12/2012", "dd/mm/yyyy").getTime()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		userDao.save(user);
	}

	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public User findUserById(Long id) {
		return userDao.findById(id);
	}
	
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void createUser(UserTransferObject userToCreate) {
		createUser(userToCreate.getUsername(), userToCreate.getEmail(), userToCreate.getFirstName(), userToCreate.getLastName(), userToCreate.getPassword());
	}

}

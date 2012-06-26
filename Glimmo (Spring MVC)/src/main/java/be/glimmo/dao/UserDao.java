package be.glimmo.dao;

import be.glimmo.domain.User;

public interface UserDao extends GenericDao<User, Long>{
	public void deleteAll();
	public User findUserByUsernameOrEmail(String username, String email);
}

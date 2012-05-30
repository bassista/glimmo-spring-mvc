package be.glimmo.dao;

import org.springframework.stereotype.Repository;

import be.glimmo.domain.User;

@Repository
public class UserDaoImpl extends GenericDaoImpl<User, Long> implements UserDao {
	

}

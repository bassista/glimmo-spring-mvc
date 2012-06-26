package be.glimmo.dao;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import be.glimmo.domain.User;

@Repository
public class UserDaoImpl extends GenericDaoImpl<User, Long> implements UserDao {

	public void deleteAll() {
		getSession().createQuery("DELETE FROM " + getEntityName()).executeUpdate();
	}

	public User findUserByUsernameOrEmail(String usernameOrEmail) {
		Query query = getSession().getNamedQuery(User.QUERY_NAME_RETRIEVE_BY_USERNAME_OR_EMAIL);
		query.setParameter("username", usernameOrEmail);
		query.setParameter("email", usernameOrEmail);
		return (User) query.uniqueResult();
	}
	

}

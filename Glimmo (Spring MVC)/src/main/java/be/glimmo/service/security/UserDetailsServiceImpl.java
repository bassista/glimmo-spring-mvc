package be.glimmo.service.security;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import be.glimmo.dao.UserDao;
import be.glimmo.domain.User;

@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService{
	@Autowired
	UserDao userDao;
	
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {
		User user = null;
		
		try{
			user = userDao.findUserByUsernameOrEmail(usernameOrEmail);
		}catch(HibernateException e){
			throw new UsernameNotFoundException(e.getMessage());
		}

		Set<GlimmoUserAuthority> authorities = new HashSet<GlimmoUserAuthority>(1); 
		authorities.add(new GlimmoUserAuthority(user.getGrade()));
		GlimmoUserDetails gud = new GlimmoUserDetails(user.getUsername(), user.getPassword(), authorities);
		
		return gud;
	}

}

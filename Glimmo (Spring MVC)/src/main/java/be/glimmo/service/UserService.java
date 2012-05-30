package be.glimmo.service;

import be.glimmo.domain.User;

public interface UserService {
	public void createUser(String username, String email, String firstname, String lastname, String password);
	public User findUserById(Long id);
}

package be.glimmo.service;

import be.glimmo.domain.User;
import be.glimmo.dto.UserTransferObject;

public interface UserService {
	public void createUser(String username, String email, String firstname, String lastname, String password);
	public void createUser(UserTransferObject userToCreate);
	public User findUserById(Long id);
	public User findUserByUsername(String username);
	public boolean checkEmailAvailability(String email);
	public boolean checkUsernameAvailability(String username);
}

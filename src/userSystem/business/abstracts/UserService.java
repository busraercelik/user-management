package userSystem.business.abstracts;

import userSystem.entities.User;

public interface UserService {
	void register(User user);
	void login(User user);
	boolean checkPasswordLength(String password);
	boolean isEmailValid(String email);
	boolean checkNameLength(String fname, String lname);
}

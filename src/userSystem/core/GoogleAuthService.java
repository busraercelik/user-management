package userSystem.core;

import userSystem.entities.User;

public interface GoogleAuthService {
	boolean authenticateGoogleMailAccount(String email, String password);
}

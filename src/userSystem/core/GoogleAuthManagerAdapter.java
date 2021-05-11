package userSystem.core;

import userSystem.entities.User;
import userSystem.googleAuth.GoogleAuthManager;

public class GoogleAuthManagerAdapter implements GoogleAuthService {

	@Override
	public void signUpGoogle(User user) {
		GoogleAuthManager authManager = new GoogleAuthManager(new JLoggerManagerAdapter());
		authManager.signUpGoogle(user);
	}

}

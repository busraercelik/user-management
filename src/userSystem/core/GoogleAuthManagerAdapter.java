package userSystem.core;

import userSystem.database.concrets.UserDatabase;
import userSystem.entities.User;
import userSystem.googleAuth.GoogleAuthManager;

public class GoogleAuthManagerAdapter implements GoogleAuthService {

	@Override
	public boolean authenticateGoogleMailAccount(String email, String password) {
		boolean flag = false;
		for(User user: UserDatabase.getGmailList()) {
			if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
				flag = true;
			}
		}
		return flag;
	}

}

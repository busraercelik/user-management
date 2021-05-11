package userSystem.googleAuth;

import userSystem.core.LoggerService;
import userSystem.entities.User;

public class GoogleAuthManager {
	
	private LoggerService loggerService;
	
	public GoogleAuthManager(LoggerService loggerService) {
		this.loggerService = loggerService;
	}
	
	public void signUpGoogle(User user) {
		loggerService.logToSystem("Welcome, "+user.getFirstName());
	}
}

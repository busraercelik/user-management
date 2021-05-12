package userSystem.business.concretes;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import userSystem.business.abstracts.UserService;
import userSystem.core.GoogleAuthService;
import userSystem.core.GoogleVerificationService;
import userSystem.core.LoggerService;
import userSystem.dataAccess.abstracts.UserDao;
import userSystem.entities.User;

public class UserManager implements UserService{
	
	private UserDao userDao;
	private LoggerService loggerService;
	private GoogleAuthService authService;
	private GoogleVerificationService verificationService;

	public UserManager(UserDao userDao,LoggerService loggerService,GoogleAuthService authService,GoogleVerificationService verificationService) {
		this.userDao = userDao;	
		this.loggerService = loggerService;
		this.authService = authService;
		this.verificationService = verificationService;
	}

	@Override
	public void register(User user) {
		if (checkPasswordLength(user.getPassword()) && 
				isEmailValid(user.getEmail())) {
			userDao.add(user);
		} else {
			loggerService.logToSystem("Registration failed!");
			return;
		}
		
		if(!verificationService.verification(user.getEmail())) {
			loggerService.logToSystem("Mail address could not verified! :(");
		} else {
			loggerService.logToSystem("Verification is successfull");
		}
	}

	@Override
	public void login(User user) {
		User userInDb = userDao.getOne(user.getId());
		
		if(user.getEmail().trim().equals("") || user.getPassword().equals("")) {
			return;
		}
		
		if (authService.authenticateGoogleMailAccount(user.getEmail(), user.getPassword())) {
				loggerService.logToSystem("Successfully entered.");
		} else {
			loggerService.logToSystem("Entered email or password is incorrect!");
		}
	}
	

	@Override
	public boolean checkPasswordLength(String password) {
		
		if(password.length() < 6 ) {
			System.out.println("Password must include min 6 characters!");
			return false;
		}
		return true;
	}

	@Override
	public boolean isEmailValid(String email) {
		
		String regex = "^(.+)@(.+)$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(email);
		
		if (matcher.matches()) {
			return true;
		}
		return false;
	}

	@Override
	public boolean checkNameLength(String fname, String lname) {
		
		if(fname.length() >= 2 && lname.length() >= 2) {
			System.out.println("Name and surname must include at least 2 characters!");
			return true;
		}
		return false;
	}
}

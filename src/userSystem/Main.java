package userSystem;

import userSystem.business.abstracts.UserService;
import userSystem.business.concretes.UserManager;
import userSystem.core.GoogleAuthManagerAdapter;
import userSystem.core.GoogleVerificationManager;
import userSystem.core.JLoggerManagerAdapter;
import userSystem.dataAccess.abstracts.UserDao;
import userSystem.dataAccess.concretes.HibernateUserDao;
import userSystem.entities.User;

public class Main {
	public static void main(String[] args) {
		
		User user = new User(1,"busra","abc","a@gmail.com","123456");
		
		UserService userService = new UserManager(new HibernateUserDao(), new JLoggerManagerAdapter(),
								  new GoogleAuthManagerAdapter(), new GoogleVerificationManager());
		userService.register(user);
		userService.login(user);
	}
}

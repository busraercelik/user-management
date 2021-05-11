package userSystem;

import userSystem.business.abstracts.UserService;
import userSystem.business.concretes.UserManager;
import userSystem.core.JLoggerManagerAdapter;
import userSystem.dataAccess.abstracts.UserDao;
import userSystem.dataAccess.concretes.HibernateUserDao;
import userSystem.entities.User;

public class Main {
	public static void main(String[] args) {
		User user = new User(1,"busra","abc","a@b.com","123");
	
		UserDao dao = new HibernateUserDao();
		dao.add(user);
		
		User user2 = new User(1,"busra","abc","a@b.com","1234");
		
		UserService userService = new UserManager(dao, new JLoggerManagerAdapter());
		userService.login(user2);
		
	}
}

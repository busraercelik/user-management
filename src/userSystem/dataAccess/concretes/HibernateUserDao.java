package userSystem.dataAccess.concretes;

import java.util.List;

import userSystem.core.JLoggerManagerAdapter;
import userSystem.dataAccess.abstracts.UserDao;
import userSystem.database.concrets.UserDatabase;
import userSystem.entities.User;

public class HibernateUserDao implements UserDao{

	@Override
	public void add(User user) {
		System.out.println("Hibernate ile eklendi: " + user.getFirstName());
	}

	@Override
	public void delete(User user) {
		System.out.println("Hibernate ile silindi: " + user.getFirstName());
	}

	@Override
	public void update(User user) {
		System.out.println("Hibernate ile güncellendi: " + user.getFirstName());
	}

	@Override
	public User getOne(long id) {
		for(User user : UserDatabase.getUserList()) {
			if (user.getId() == id) {
				return user;
			}
		}
		return null;
	}

	@Override
	public List<User> getAll() {
		try {
			return UserDatabase.getUserList();
		}catch(Exception e) {
			JLoggerManagerAdapter logger = new JLoggerManagerAdapter();
			logger.logToSystem("HibernateUserDao failed -> "+ e.getMessage());
		}
		return null;
	}

}

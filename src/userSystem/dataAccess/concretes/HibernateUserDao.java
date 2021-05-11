package userSystem.dataAccess.concretes;

import java.util.List;

import userSystem.dataAccess.abstracts.UserDao;
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
		
		return null;
	}

	@Override
	public List<User> getAll() {
		
		return null;
	}

}

package userSystem.dataAccess.abstracts;

import java.util.List;

import userSystem.entities.User;

public interface UserDao {
	void add(User user);
	void delete(User user);
	void update(User user);
	User getOne(long id);
	List<User> getAll();
}

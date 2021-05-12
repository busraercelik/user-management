package userSystem.database.concrets;

import java.util.ArrayList;
import java.util.List;
import userSystem.entities.User;

public class UserDatabase {
	

	static User user1 = new User(1,"busra","abc","a@gmail.com","123456");
	static User user2 = new User(2,"john","abc","j@gmail.com","456123");
	static User user3 = new User(3,"sam","abc","s@b.com","789342");
	
	public static List<User> getUserList() {
		List<User> userList = new ArrayList<User>();
		userList.add(user1);
		userList.add(user2);
		userList.add(user3);
		
		return userList;
	}
	
	public static List<User> getGmailList(){
		List<User> gmailUserList = new ArrayList<User>();
		gmailUserList.add(user1);
		gmailUserList.add(user2);
		
		return gmailUserList;
	}
}

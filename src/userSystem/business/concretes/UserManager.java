package userSystem.business.concretes;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import userSystem.business.abstracts.UserService;
import userSystem.core.LoggerService;
import userSystem.dataAccess.abstracts.UserDao;
import userSystem.entities.User;

public class UserManager implements UserService{
	
	private UserDao userDao;
	private LoggerService loggerService;

	public UserManager(UserDao userDao,LoggerService loggerService) {
		this.userDao = userDao;	
		this.loggerService = loggerService;
	}

	@Override
	public void register(User user) {
		if (checkPasswordLength(user.getPassword()) && 
				isEmailValid(user.getEmail())) {
			userDao.add(user);
			loggerService.logToSystem("Doğrulama linki için mail adresinizi kontrol ediniz");
			
		} else {
			loggerService.logToSystem("Kayıt işlemi gerçekleştirilemedi!");
		}
		
	}

	@Override
	public void login(User user) {
		User userInDb = userDao.getOne(user.getId());
		
		if(user.getEmail().trim().equals("") || user.getPassword().equals("")) {
			return;
		}
		if (userInDb.getEmail().equals(user.getEmail()) && 
				userInDb.getPassword().equals(user.getPassword())) {
			loggerService.logToSystem("Başarılı ile giriş yapıldı.");
		} else {
			loggerService.logToSystem("Girilen email veya şifre hatalı!");
		}
	}
	

	@Override
	public boolean checkPasswordLength(String password) {
		
		if(password.length() < 6 ) {
			System.out.println("Parola en az 6 karakterden oluşmalıdır!");
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
			System.out.println("Ad ve soyad en az 2 karakterden oluşmalıdır!");
			return true;
		}
		return false;
	}

	@Override
	public void sendVerificationLink() {
		// TODO Auto-generated method stub
		
	}

}

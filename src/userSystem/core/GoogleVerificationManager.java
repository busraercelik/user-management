package userSystem.core;

import java.util.Scanner;

public class GoogleVerificationManager implements GoogleVerificationService{
	
	public boolean verification(String email) {
		boolean flag = false;
		Scanner scan = new Scanner(System.in);
		System.out.println("Please type ok");
		String respond = scan.nextLine();
		
		if (respond.equals("ok")) {
			flag = true;
		}
		return flag;
	}
}

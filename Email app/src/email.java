import java.util.Random;
import java.util.Scanner;

public class email {

	private String firstName;
	private String lastName;
	private String Department;
	private String password;
	private int mailCapacity;
	private int pwdLength = 6;
	private String altEmail;
	Scanner scanner = new Scanner(System.in);
	Random rnd = new Random();
	// Constructor to receive the first and last name
	public email(String firstName, String lastName){
		this.firstName = firstName;
		this.lastName = lastName;
		System.out.println("Email created: " + this.firstName +" "+ this.lastName);
		
		this.Department = department();
		
		System.out.println("Your department is: " + Department);
		
		this.password = rndpassword(pwdLength);
		
		System.out.println("Your password is: " + this.password);
		
		String adress = this.firstName + "." + this.lastName + "@" + Department + ".company.com";
		
		System.out.println("Your email adress is: " + adress);
		
	}
	// Ask for department
	private String department() {
		System.out.println();
		System.out.println("What is your department?");
		System.out.println("Enter \n1 for Sales \n2 for Development \n3 for Accounting \n0 For none");
		int depChoice = scanner.nextInt();
		if (depChoice == 1) { return "sales"; }
		else if (depChoice == 2) { return "dev"; }
		else if (depChoice == 3) { return "accnt"; }
		else{ return ""; }	
	}
	
	
	//generate random string for password
	private String rndpassword(int length) {
		String pwdCharacters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890@!?"; 
		char[] password = new char[length];
		for (int i = 0; i < length; i++) {
			int rand = (int) (Math.random() * pwdCharacters.length());
			password[i] = pwdCharacters.charAt(rand);
		}
		return new String(password);
	}
	//change password
	void changePW(String newPassword) {
		password = newPassword;
	}
	//change mailbox capacity
	void capacity(int cap) {
		mailCapacity = cap;
	}
	//define alternate email address
}

import java.util.Scanner;

public class account {
	
	int balance;
	int previousTransaction;
	double intvalue;
	String Name;
	String ID;
	
account(String CName, String CID) {
		Name = CName;
		ID = CID;
	}
	void deposit(int dep) {
		if (dep != 0) {
			balance += dep;
			previousTransaction = dep;
		}
	}
	void withdraw(int withdrawal) {
		if (withdrawal != 0)
			balance -= withdrawal;
			previousTransaction = -withdrawal;
	}
	void getPreviousTransaction() {
		if (previousTransaction > 0)
			System.out.println("Deposited: " + previousTransaction);
		else if (previousTransaction < 0)
			System.out.println("Withdrawn: " + previousTransaction * (-1));
		else if (previousTransaction == 0)
			System.out.println("No transaction occured");
	}
	void interest(int years) {
		double rate = 2.25 / 100;
		if (years != 0)
			intvalue = balance * Math.pow(1 + rate, years);
		System.out.println("The current interest rate is 2.25%");
		System.out.println("Your interest in " + years + "years will be: " + intvalue);
		
						
	}
	void showMenu() {
		char option;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Welcome, " + Name);
		System.out.println("Your ID is: " + ID);
		System.out.println();
		System.out.println("What would you like to do?");
		System.out.println();
		System.out.println("A. Check your balance");
		System.out.println("B. Make a Deposit");
		System.out.println("C. Make a Withdrawal");
		System.out.println("D. Calculate interest");
		System.out.println("E. Get previous transaction");
		System.out.println("F. Exit");
		
		int amount;
		do {
			System.out.println();	
			System.out.println("Choose an option: ");
			System.out.println();
			char option1 = scanner.next().charAt(0);
			option = Character.toUpperCase(option1);
			switch(option) {
				case ('A'):
					System.out.println();
					System.out.println("Your balance is: $" + balance);
					System.out.println();
					break;
				case ('B'):
					System.out.println();
					System.out.println("How much would you like to deposit?");
					System.out.println("Enter number: ");
					amount = scanner.nextInt();
					deposit(amount);
				break;
				case('C'):
					System.out.println();
					System.out.println("How much would you like to withdraw?");
					System.out.println("Enter number: ");
					amount = scanner.nextInt();
					withdraw(amount);	
				break;
				case('D'):
					System.out.println();
					System.out.println("Enter how many years of accured interest: ");
					amount = scanner.nextInt();
					interest(amount);
				break;
				case('E'):
					System.out.println();
					System.out.println("Your previous transactions was: ");
					getPreviousTransaction();
				break;
				}
			} while(option != 'F');
			
		System.out.println("Thank you for being a valued customer!");
	}
}


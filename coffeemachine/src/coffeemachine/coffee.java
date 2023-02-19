package coffeemachine;
import java.util.Scanner;
public class coffee {
	public static int currentWater = 400;
	public static int currentMilk = 540;
	public static int currentGrams = 120;
	public static int currentCups = 9;
	public static int currentMoney = 550;
	final static Scanner s = new Scanner(System.in);
	
	
	public static void main(String[] args) {
		while (true) {
			System.out.println();
			System.out.println("Write action (buy, fill, take, remaining, exit): ");
			String action = s.next();
		switch (action) {
		case "buy": buy(); break;
		case "fill": fill(); break;
		case "take": take(); break;
		case "remaining": state(); break;
		case "back": break;
		case "exit": return;
		}

		}
		
	}
	static void buy() {
		String missing;
		System.out.println();
		System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino: ");
		String coffee = s.next();
		
		if (coffee.equals("back")) return;
		
		switch (Integer.parseInt(coffee)) {
		case 1:
			if (currentWater >= 250 && currentGrams >= 16 && currentCups >= 1) {
				System.out.println("I have enough resources, making you a coffee!");
				currentWater -= 250;
				currentGrams -= 16;
				currentMoney += 4;
				currentCups--;
			}
			else {
				missing = currentWater < 250 ? "water" : currentGrams < 16 ? "coffee" : "cups";
				System.out.println("Sorry, not enough " + missing);
			}
			break;
		case 2:
			if (currentWater >= 350 && currentMilk >= 75 && currentGrams >= 20 && currentCups >= 1) {
				System.out.println("I have enough resources, making you a coffee!");
				currentWater -= 350;
				currentMilk -= 75;
				currentGrams -= 20;
				currentMoney += 7;
				currentCups--;
			}
			else {
				missing = currentWater < 350 ? "water" : currentMilk < 75 ? "Milk" : currentGrams < 20 ? "coffee" : "cups";
				System.out.println("Sorry, not enough " + missing);
			}
			break;
			
		case 3:
			if (currentWater >= 200 && currentMilk >= 100 && currentGrams >= 12 && currentCups >= 1) {
				System.out.println("I have enough resources, making you a coffee!");
				currentWater -= 200;
				currentMilk -= 100;
				currentGrams -= 12;
				currentMoney += 6;
				currentCups--;
			}
			else {
				missing = currentWater < 200 ? "water" : currentMilk < 100 ? "Milk" : currentGrams < 12 ? "coffee" : "cups";
				System.out.println("Sorry, not enough " + missing);
			}
			break;
		}
	}
	static void fill() {
		System.out.println("Write how many ml of water you want to add: ");
		currentWater += s.nextInt();
		System.out.println("Write how many ml of milk you want to add: ");
		currentMilk += s.nextInt();
		System.out.println("Write how many grams of coffee beans you want to add: ");
		currentGrams += s.nextInt();
		System.out.println("Write how many disposable cups you want to add: ");
		currentCups += s.nextInt();
		
	}
	static void take() {
		System.out.println("I gave you $" + currentMoney);
		currentMoney = 0;
	}
	static int countCups(int water, int milk, int grams) {		
		return Math.min(Math.min(water / 200, milk / 50), grams / 15);
	}
	static void state() {
		System.out.println("The coffee machine has:\r\n"
				+ currentWater + " ml of water\r\n"
				+ currentMilk + " ml of milk\r\n"
				+ currentGrams + " g of coffee beans\r\n"
				+ currentCups +" disposable cups\r\n"
				+ "$" + currentMoney + " of money");
	}

}

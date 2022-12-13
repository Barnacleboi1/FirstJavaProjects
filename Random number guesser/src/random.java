import java.util.Random;
import java.util.Scanner;

public class random {
	Random rnd = new Random();
	int correct = rnd.nextInt(1, 101);
	int guessesLeft = 5;
	Scanner scanner = new Scanner(System.in);
	
	
	random(){}
	
	void incorrectValue() {
		System.out.println();
		System.out.println("Please enter a value between 1 and 100");
	}
	
	void tooHigh() {
		System.out.println();
		System.out.println("Too high");
	}
	
	void tooLow() {
		System.out.println();
		System.out.println("Too low");
	}
	
	void game() {
		System.out.println();
		System.out.println("Hello! Welcome to our game!");
		int guess;
		do {
			System.out.println();
			System.out.println("Please, guess a number between 1 and 100: ");
			guess = scanner.nextInt();
			
			if (guess < 1 || guess > 100) 
				incorrectValue();
			
			else if (guess > correct) {
				tooHigh();
				guessesLeft--;
				System.out.println("Guesses left: " + guessesLeft);
			}
			
			else if (guess < correct) {
				tooLow();
				guessesLeft--;
				System.out.println("Guesses left: " + guessesLeft);
			}
			
			else if (guess == correct) {
				System.out.println();
				System.out.println("Your guess was correct!");
				System.out.println("Thanks for playing our game!");
				System.exit(0);
			}
	
		}while (guessesLeft != 0);
		System.out.println("You ran out of guesses!");
		System.out.println("Thanks for playing our game!");
	}
}

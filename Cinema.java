package bla;

import java.util.Scanner;
public class Cinema {
	static int total = 0;
	static int ticketCount = 0;
	static int currInc = 0;
	public static void main(String[] args) {
		
		
		Scanner s = new Scanner(System.in);
		
        System.out.println("Enter the number of rows:");
        int row = s.nextInt();
        
        System.out.println("Enter the number of seats in each row:");
        int seat = s.nextInt();
        
        String[][] cin = new String[row + 1][seat + 1];
        setTheather(cin);
        
        while (true) {
        System.out.println();
        System.out.println("1. Show the seats");
        System.out.println("2. Buy a ticket");
        System.out.println("3. Statistics");
        System.out.println("0. Exit");
        int ans = s.nextInt();
        
        if (ans == 1) {
        	show(cin);
        }
        else if (ans == 2) {
        	buy(row, seat, cin);
        }
        else if (ans == 3){
        	stats(row, seat);
        }
        else if (ans == 0) {
        	break;
        }
        }
        System.out.print("Thank you for coming!");
        	
        }
    	static void setTheather(String[][] cinema) {
		for (int i = 0; i < cinema.length; i++) {
			for (int j = 0; j < cinema[i].length; j++) {
				if (i == 0 && j == 0) {
					cinema[i][j] = " ";
				}
				else if (i == 0) {
					cinema[i][j] = String.valueOf(j);
				}
				else if (j == 0) {
					cinema[i][j] = String.valueOf(i);
				}
				else {
					cinema[i][j] = "S";
				}
			}
		}
	}
    	static void show(String[][] cinema) {
		System.out.println();
		System.out.print("Cinema:");
		System.out.println();
		for (int i = 0; i < cinema.length; i++) {
			for (int j = 0; j < cinema[i].length; j++) {
				System.out.print(cinema[i][j] + " ");
			}
			System.out.println();
		}	
	}
    	static void buy(int row, int seat, String[][] cinema) {
            Scanner s = new Scanner(System.in);
        
        while(true) {
            System.out.println("Enter a row number:");
            int cusRow = s.nextInt();
            System.out.println("Enter a seat number in that row:");
            int cusSeat = s.nextInt();
            
            int tPrice = row * seat < 60 ? 10 : cusRow <= row/2 ? 10 : 8;
            
        	if (cusRow * cusSeat > row * seat || cusRow > row || cusSeat > seat){
        		System.out.println();
        		System.out.println("Wrong input!");
        		System.out.println();
        		continue;
        	}
            
        	else if (cinema[cusRow][cusSeat] == "B") {
        		System.out.println();
        		System.out.println("That ticket has already been purchased!");
        		System.out.println();
        		continue;
        	}

        	else {
                System.out.println("Ticket price: $" + tPrice);
                System.out.println();
                
                cinema[cusRow][cusSeat] = "B";
                total++;
                currInc += tPrice;
                break;
        	}
        }
        
	}
    	static void stats(int row, int seat) {
    		float seatAm = row * seat;
    		float percentage = total / seatAm * 100;
    		System.out.println("Number of purchased tickets: " + total);
    		System.out.printf("Percentage: %.2f%%", percentage);
    		System.out.println();
    		System.out.println("Current incom be: $" + currInc);
    		int totalInc = row * seat < 60 ? row * seat * 10 : row * seat/2 * 10 + (row * seat - (row * seat/2 + 1)) * 8;
    		System.out.println("Total income: $" + totalInc);
    	}
}
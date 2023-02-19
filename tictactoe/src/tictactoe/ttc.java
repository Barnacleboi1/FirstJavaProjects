package tictactoe;

import java.util.Scanner;
public class ttc {
	private static void printField(char[][] field) {

		System.out.println("---------");
		for (int i = 0; i < 3; i++) {
			System.out.print("| ");
			for (int j = 0; j < 3; j++){
				System.out.print(field[i][j] + " ");
			}
			System.out.println("|");
		}
		System.out.println("---------");
	}
	private static String state(char[][] field) {
		
		boolean xwin = false;
		boolean owin = false;
		int xs = 0;
		int os = 0;
		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++){
				if (field[i][j] == 'X') {
					xs++;
				}
				else if (field[i][j] == 'O') {
					os++;
				}
			}
		}
	
		
		for (int i = 0; i < 3; i++) {
			int row = 0;
			int col = 0;
			int diag = 0;
			int rdiag = 0;
			for (int j = 0; j < 3; j++) {
				row += field[i][j];
				col += field[j][i];
				diag += field[j][j];
				rdiag += field[j][2 - j];
			}
			xwin = xwin || row == 264 || col == 264 || diag == 264 || rdiag == 264;

			owin = owin || row == 237 || col == 237 || diag == 237 || rdiag == 237;

		}
		String result = new String();
		if (xwin) {
			result = "X wins";
		}
		else if (owin) {
			result = "O wins";
		}
		else if (xs + os == 9) {
			result = "Draw";
		}
		return result;

	}
	
	public static void main(String[] args) {
	
		Scanner s = new Scanner(System.in);
		

		char[][] field = new char[3][3];
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				field[i][j] = ' ';
			}
		}
		int count = 0;
		
		while (true){
			try {
			printField(field);
			if (state(field) == "X wins") {
				System.out.print("X wins");
				break;
			}
			else if (state(field) == "O wins") {
				System.out.print("O wins");
				break;
			}
			else if (state(field) == "Draw") {
				System.out.print("Draw");
				break;
			}
			String n1 = s.next();
			String n2 = s.next();
			count++;
			if (Integer.parseInt(n1) > 3 || Integer.parseInt(n1) < 1 || Integer.parseInt(n2) > 3 || Integer.parseInt(n2) < 1){
				System.out.println("Coordinates should be from 1 to 3!");
				count--;
				continue;
			}
			
			else if (field[Integer.parseInt(n1) - 1][Integer.parseInt(n2) - 1] == 'X' || field[Integer.parseInt(n1) - 1][Integer.parseInt(n2) - 1] == 'O') {
				System.out.println("This cell is occupied! Choose another one!");
				count--;
				continue;
			}
			else if (count % 2 == 0){
				field[Integer.parseInt(n1) - 1][Integer.parseInt(n2) - 1] = 'O';
				continue;
				}
			else {
				field[Integer.parseInt(n1) - 1][Integer.parseInt(n2) - 1] = 'X';
				continue;
			}
			}
			
			catch (NumberFormatException e){
				System.out.println("You should enter numbers!");
				count--;
			}

		}

	}
	

}

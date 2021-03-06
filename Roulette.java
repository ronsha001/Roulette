import java.util.Scanner;

public class Roulette {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int[][] roll = new int[12][3];
		int num = 1;
		for (int i = 0; i < roll.length; i++) {
			for (int j = 0; j < 3; j++) {
				roll[i][j] = num++;
			}
		}
		System.out.println("   0");
		for (int i = 0; i < roll.length; i++) {
			for (int j = 0; j < 3; j++) {
				if (roll[i][j] < 10) {
					System.out.print(roll[i][j] + "  ");
				} else {
					System.out.print(roll[i][j] + " ");
				}
			}
			System.out.println();
		}
		int bet = 0;
		while (bet < 1 || bet > 3) {
			System.out.println("Do you want to bet on color? --> 1");
			System.out.println("Do you want to bet on row? --> 2");
			System.out.println("Do you want to bet on number? --> 3");
			bet = s.nextInt();
			if (bet < 1 || bet > 3) {
				System.err.println("Invalid Input !");
			}
		}
		switch (bet) {
		case 1:
			String color = "";
			while (!color.equals("RED") && !color.equals("BLACK")) {
				System.out.println("Which color?\nRed\nBlack");
				color = s.next();
				color = color.toUpperCase();
				if (!color.equals("RED") && !color.equals("BLACK")) {
					System.err.println("Invalid Input !");
				}
			}
			int dice = (int) (Math.random() * 37);
			int[] red = {1,3,5,7,9,12,14,16,18,19,21,23,25,27,30,32,34,36};
			int [] black = {2,4,6,8,10,11,13,15,17,20,22,24,26,28,29,31,33,35};
			int flagRed = 0;
			int flagBlack = 0;
			int flagFailed = 0;
			for (int i = 0; i < red.length; i++) {
				if (dice == red[i] && color.equals("RED")) {
					flagRed++;
				} else if (dice == black[i] && color.equals("BLACK")) {
					flagBlack++;
				} else {
					flagFailed++;
				}
			}
			if (flagRed > 0) {
				System.out.println("Final Number is: "+dice+"\n"+dice+" is Red, You Won ! ");
			} else if (flagBlack > 0) {
				System.out.println("Final Number is: "+dice+"\n"+dice+" is Black, You Won ! ");
			} else if (flagFailed > 0){
				System.out.println("Final Number is:"+dice+"\n"+dice+" is not the color you've chosen, you've lost !");
			}
			break;
		case 2:
			int[] row1 = {1,4,7,10,13,16,19,22,25,28,31,34};
			int[] row2 = {2,5,8,11,14,17,20,23,26,29,32,35};
			int[] row3 = {3,6,9,12,15,18,21,24,27,30,33,36};
			int flag1 = 0;
			int flag2 = 0;
			int flag3 = 0;
			String row = "";
			while (!row.equals("ROW1") && !row.equals("ROW2") && !row.equals("ROW3")) {
				System.out.println("Choose row to bet on: \nRow 1\nRow 2\nRow 3");
				row = s.next();
				row = row.toUpperCase();
				if (!row.equals("ROW1") && !row.equals("ROW2") && !row.equals("ROW3")) {
					System.err.println("Invalid Input !");
				}
			}
			dice = (int) (Math.random() * 37);
			
			for (int i = 0; i < row1.length; i++) {
				if (dice == row1[i] && row.equals("ROW1")) {
					flag1++;
				} else if (dice == row2[i] && row.equals("ROW2")) {
					flag2++;
				} else if (dice == row3[i] && row.equals("ROW3")) {
					flag3++;
				}
			}
			if (flag1 > 0) {
				System.out.println("Final Number is: "+dice+"\n"+dice+" is on Row 1, you won !");
			} else if (flag2 > 0) {
				System.out.println("Final Number is: "+dice+"\n"+dice+" is on Row 2, you won !");
			} else if (flag3 > 0) {
				System.out.println("Final Number is: "+dice+"\n"+dice+" is on Row 3, you won !");
			} else {
				System.out.println("Final Number is: "+dice+"\n"+dice+" is not on the row you've chosen, you've lost !");
			}
			break;
		case 3:
			dice = (int)(Math.random()*37);
			num = -5;
			while (num < 0 || num > 36) {
				System.out.print("Bet please (0-36): ");
				num = s.nextInt();
				if (num < 0 || num > 36) {
					System.err.println("Invalid Input !");
				}
			}
			if (dice == num) {
				System.out.println("Final Number is: "+dice+"\n"+dice+" is your number, you've just won alot of money !");
			} else {
				System.out.println("Final Number is: "+dice+"\n"+dice+" is not your number, you've lost !");
			}
			break;
		}

	}

}

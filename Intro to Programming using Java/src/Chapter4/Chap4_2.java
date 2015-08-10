package Chapter4;

import java.util.Scanner;

public class Chap4_2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter a hexadecimal sequence : ");
		String str = scanner.nextLine().toUpperCase();
		int val = 0;
		for (int i = 0; i < str.length(); i++) {
			if (hexDec(str.charAt(i)) == -1) {
				System.out.println("Please enter a valid hexadecimal");
				break;
			} else {
				val = val * 16 + hexDec(str.charAt(i));
			}
		}
		System.out.println("Based-10 value : "+ val);
	}
	public static int hexDec(char c) {
		switch (c) {
		case '0' :
			return 0;
		case '1' :
			return 1;
		
		case '2' :
			return 2;
			
		case '3' :
			return 3;
			
		case '4' :
			return 4;
			
		case '5' :
			return 5;
		case '6' :
			return 6;
		case '7' :
			return 7;
		case '8' :
			return 8;
		case '9' :
			return 9;
		case 'A' :
			return 10;
		case 'B' :
			return 11;
		case 'C' :
			return 12;
		case 'D' :
			return 13;
		case 'E' :
			return 14;
		case 'F' :
			return 15;		
		default :
			return -1;
		}
	}
}

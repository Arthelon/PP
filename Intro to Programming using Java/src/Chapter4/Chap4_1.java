package Chapter4;

import java.util.Scanner;

public class Chap4_1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String str = scanner.nextLine();
		System.out.println(printCapitalised(str));
	}
	
	public static String printCapitalised(String str) {
		String newString = "";
		for (int i = 0; i < str.length(); i++) {
			if ((Character.isLetter(str.charAt(i)) && i == 0) || !Character.isLetter(str.charAt(i-1))) {
				newString += str.substring(i, i+1).toUpperCase();
				continue;
			}
			newString += str.charAt(i);
		}
		return newString;
	}
}

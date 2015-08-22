package exercises;

import java.util.Scanner;

public class E69 {
	public static boolean palindrome(String text) {
	    if (text.length() <= 1) return true;
	    if (text.charAt(0) == text.charAt(text.length()-1)) return palindrome(text.substring(1, text.length()-1));
	    return false;
	}
	
	public static void main(String[] args) {
	    Scanner reader = new Scanner(System.in);

	    System.out.println("Type a text: ");
	    String text = reader.nextLine();
	    if (palindrome(text)) {
	       System.out.println("The text is a palindrome!");
	    } else {
	       System.out.println("The text is not a palindrome!");
	    }
	}
}

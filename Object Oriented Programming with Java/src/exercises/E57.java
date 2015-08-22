package exercises;

import java.util.ArrayList;
import java.util.Scanner;

public class E57 {

	public static void main(String[] args) {
		ArrayList<String> words = new ArrayList<String>();
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.println("Type a word : ");
			String word = scanner.nextLine();
			words.add(word);
			if (word.isEmpty()) break;
		}
		
		System.out.println("You typed the following words : ");
		for (String str : words) {
			System.out.println(str);
		}
	}

}

package exercises;

import java.util.ArrayList;
import java.util.Scanner;

public class E58 {

	public static void main(String[] args) {
		ArrayList<String> words = new ArrayList<String>();
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.println("Type a word : ");
			String word = scanner.nextLine();
			if (words.contains(word)) {
				words.add(word);
				break;
			}
			words.add(word);
		}
		System.out.println("You gave the word "+words.get(words.size()-1)+" twice");

	}

}

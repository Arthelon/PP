package exercises;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class E60 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ArrayList<String> array = new ArrayList<String>();
		
		while (true) {
			System.out.println("Type a word : ");
			String word = scanner.nextLine();
			array.add(word);
			if (word.isEmpty()) break;
		}
		Collections.sort(array);
		System.out.println("You typed the following words : ");
		for (String str : array) {
			System.out.println(str);
		}
	}
}

package exercises.C2E7;

import java.util.Scanner;

public class TextUserInterface {
	
	private Scanner reader;
	private Dictionary dict;
	public TextUserInterface(Scanner reader, Dictionary dictionary) {
		this.reader = reader;
		this.dict = dictionary;
		
	}
	
	public void start() {
		System.out.println("Statements : ");
		System.out.println("add - adds a word pair to the dictionary");
		System.out.println("translate - asks a word and prints its translation");
		System.out.println("quit - quits the text user interface");
		while (true) {
			System.out.println("Statement : ");
			String next = reader.nextLine();
			
			if (next.equals("add")) add();
			if (next.equals("translate")) translate();
			if (next.equals("quit")) break;
		}
		System.out.println("Cheers!");
	}
	
	private void add() {
		System.out.println("In Finnish : ");
		String finn = reader.nextLine();
		System.out.println("Translation : ");
		String trans = reader.nextLine();
		dict.add(finn, trans);
	}
	
	private void translate() {
		System.out.println("Give a word : ");
		String key = reader.nextLine();
		System.out.println("Translation : " + dict.translate(key));
	}
}

package Chapter5;
import support.AdditionQuestion;

import java.util.Scanner;

public class Chap5_6 {
	static AdditionQuestion[] random = new AdditionQuestion[10];
	static int[] user = new int[10];
	
	public static void main(String[] args) {
		quizCreate();
		quizRun();
		quizGrade();
	}
	
	public static void quizCreate() {
		for (int i = 0; i < 10; i++) {
			random[i] = new AdditionQuestion();
		}
		
	}
	public static void quizRun() {
		Scanner scanner = new Scanner(System.in);
		int count = 0;
		System.out.println("This is a simple additions quiz");
		while (count != 10) {
			System.out.println(random[count].getQuestion());
			user[count] = scanner.nextInt();
			count++;
		}
	}
	public static void quizGrade() {
		int count = 0;
		for (int i = 0; i < 10; i++) {
			System.out.println("The problem was "+random[i].getQuestion());
			if (user[i] == random[i].getCorrectAnswer()) {
				System.out.println("You gave the correct answer of : "+ user[i]);
				count++;
			} else {
				System.out.println("You gave the incorrect answer of : "+ user[i]);
			}
		}
		System.out.println("Your total score is : "+count + " out of 10");
	}
	
	
}

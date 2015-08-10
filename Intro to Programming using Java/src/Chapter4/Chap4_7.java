package Chapter4;

import java.util.Scanner;

public class Chap4_7 {
	static int[] random1 = new int[10];
	static int[] random2 = new int[10];
	static int[] user = new int[10];
	
	public static void main(String[] args) {
		quizCreate();
		quizRun();
		quizGrade();
	}
	
	public static void quizCreate() {
		for (int i = 0; i < 10; i++) {
			random1[i] = (int)(Math.random()*25) + 1;
			random2[i] = (int)(Math.random()*25) + 1;
		}
	}
	public static void quizRun() {
		Scanner scanner = new Scanner(System.in);
		int count = 0;
		System.out.println("This is a simple additions quiz");
		while (count != 10) {
			System.out.println("What is " + random1[count] + " + " + random2[count] + "? :");
			user[count] = scanner.nextInt();
			count++;
		}
	}
	public static void quizGrade() {
		int count = 0;
		for (int i = 0; i < 10; i++) {
			System.out.println("The problem was "+random1[i] +" + "+ random2[i]);
			if (user[i] == random1[i] + random2[i]) {
				System.out.println("You gave the correct answer of : "+ user[i]);
				count++;
			} else {
				System.out.println("You gave the incorrect answer of : "+ user[i]);
			}
		}
		System.out.println("Your total score is : "+count + " out of 10");
	}
	
	
}

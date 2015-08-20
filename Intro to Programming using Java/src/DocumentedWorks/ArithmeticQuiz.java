package DocumentedWorks;
import support.AdditionQuestion; 
import support.IntQuestion;
import support.SubtractQuestion;

import java.util.Scanner; //Makes the Scanner class available for recording user input

/**
 * This class implements a 10 question long Addition and Subtraction quiz. The questions are first randomly initialized
 * using AdditionQuestion and SubtractQuestion objects that use numbers from the range 1 - 50. Afterwards,
 * the user gets to answer them 1 by 1, with the next question appearing after an answer is submitted. Once all
 * questions have been answered, the program reprints each question followed by the users answer, which is indicated
 * to be correct or incorrect. The user's score out of 10 is printed at the very end of the program.
 *
 */
public class ArithmeticQuiz {
	
	static IntQuestion[] random = new IntQuestion[10]; //Holds the Question objects
	static int[] user = new int[10];                   //Holds user input for corresponding Questions in the random array
	
	public static void main(String[] args) {
		quizCreate();    //calls subroutine that initializes the "random" array
		quizRun();       //calls subroutine that has user answer questions
		quizGrade();     //calls subroutine that grades and prints based on user input
	} //end of main()
	
	/**
	 * Initializes "random" array with AdditionQuestion and SubtractQuestion objects
	 */
	public static void quizCreate() {
		for (int i = 0; i < 10; i++) {
			if ((int)(Math.random()*2) == 0) {     //Uses a random number to decide which type of question is chosen.
				random[i] = new AdditionQuestion();
			} else {
				 random[i] = new SubtractQuestion();
			}
		}
		
	}
	
	/**
	 * Prints and allows user to answer questions, recording their responses into an array
	 */
	public static void quizRun() {
		Scanner scanner = new Scanner(System.in);
		int count = 0;
		System.out.println("This is a simple arithmetic quiz");
		while (count != 10) { //Stops when user has answered 10 questions
			System.out.println(random[count].getQuestion());
			user[count] = scanner.nextInt(); //Stores user response to corresponding array location
			count++;
		}
	}
	/**
	 * Reprints all questions and tells the user if their answer was correct. The users score
	 * is printed at the very end
	 */
	public static void quizGrade() {
		int count = 0;   //Stores the score of the user
		for (int i = 0; i < 10; i++) {
			System.out.println("The problem was "+random[i].getQuestion());   
			if (user[i] == random[i].getCorrectAnswer()) {   //Evaluates user response against the answer of the question
				System.out.println("You gave the correct answer of : "+ user[i]);  
				count++; //Incremented by one if the user answers the question correctly
			} else {
				System.out.println("You gave the incorrect answer of : "+ user[i]);
			}
		}
		System.out.println("Your total score is : "+count + " out of 10");
	}
}

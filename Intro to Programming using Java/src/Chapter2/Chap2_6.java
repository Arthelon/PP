package Chapter2;
import java.util.Scanner;


public class Chap2_6 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter your first name and last name (seperated with a space)");
		String name = scanner.nextLine();
		
		int index = name.indexOf(" ");
		String firstName = name.substring(0, index);
		String lastName = name.substring(index+1, name.length());
		
		System.out.println("Your first name is "+firstName+", which has "+firstName.length()+" characters");
		System.out.println("Your last name is "+lastName+", which has "+lastName.length()+" characters");
		System.out.println("Your initials are : " + firstName.substring(0, 1).toUpperCase() + lastName.substring(0, 1).toUpperCase());
	}
}

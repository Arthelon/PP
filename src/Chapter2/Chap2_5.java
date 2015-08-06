package Chapter2;
import java.util.Scanner;


public class Chap2_5 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("How many eggs do you have?");
		int eggs = scanner.nextInt();
		
		int gross = eggs / 144;
		int remainder1 = eggs % 144;
		int dozen = remainder1/12;
		int remainder2 = remainder1%12;
		
		System.out.println("gross : "+gross+"\ndozen : "+dozen+"\nremainder "+remainder2);
	}
}

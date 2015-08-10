import java.util.ArrayList;
import java.util.Scanner;

public class LifeUniverseEverything {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ArrayList<Integer> numArray = new ArrayList<Integer>();
		
		int num = scanner.nextInt();
		while (num != 42) {
			numArray.add(num);
			num = scanner.nextInt();
		}
		for (int i = 0; i < numArray.size(); i++) {
			System.out.println(numArray.get(i));
		}

	}

}

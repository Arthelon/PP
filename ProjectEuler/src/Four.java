import java.util.ArrayList;
import java.util.Collections;


public class Four {
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		int num1 = 1000;
		int num2 = 1000;
		for (int i = 1; i < 1000; i++) {
			for (int i2 = 1; i2 < 1000; i2++) {
				if (check((num1-i)*(num2-i2))) {
					list.add((num1-i)*(num2-i2));
				}
			}
		}
		Collections.sort(list);
		System.out.println("Largest Palindrome : " + list.get(list.size()-1));
	}
	
	public static boolean check(int palin) {
		String num = Integer.toString(palin);
		for (int i = 0; i < num.length(); i++) {
			if (num.charAt(i) != num.charAt(num.length()-1-i)) {
				return false;
			}
		}
		return true;
	}
}

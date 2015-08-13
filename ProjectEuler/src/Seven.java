import java.util.ArrayList;
import java.util.Scanner;


public class Seven {
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		int p = 2;
		int constant;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Find the largest prime within : ");
		int nth = Integer.parseInt(scanner.nextLine());
		
		for (int i = 2; i <= nth; i++) {
			list.add(i);
		}
		for (int i2 = 2; i2 <= nth; i2++) {
			p += 2;
			list.remove(Integer.valueOf(p));
		}
		for (int i3 = 0; i3 < list.size(); i3++) {
			p = list.get(i3);
			constant = p;
			for (int i4 = 0; i4 < list.size(); i4++) {
				p += constant;
				list.remove(Integer.valueOf(p));
			}
		}
		System.out.println(list.get(list.size()-1));
	}
}

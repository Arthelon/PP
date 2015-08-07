package Chapter3;

public class Chap3_2 {
	public static void main(String[] args) {
		int divCount = 0;
		int num = 0;
		for (int i = 1; i <= 10000; i++) {
			int newDiv = 0;
			int i2 = 0;
			for (i2 = 1; i2 <= i; i2++) {
				if (i % i2 == 0) {
					newDiv++;
				}
			}
			if (newDiv > divCount) {
				divCount = newDiv;
				num = i2;
			}
		}
		
		System.out.println(num);
	}
}

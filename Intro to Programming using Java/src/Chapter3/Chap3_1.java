package Chapter3;

public class Chap3_1 {
	public static void main(String[] args) {
		int count = 0;
		int roll1;
		int roll2;
		
		do {
			roll1 = roll();
			roll2 = roll();
			count ++;
		} while (roll1 != 1 || roll2 != 1);
		
		System.out.println(count);
	}
	public static int roll() {
		return (int) (Math.random() * 6) + 1;
	}
}

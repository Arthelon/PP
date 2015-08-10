package Chapter4;

public class Chap4_3and4 {

	public static void main(String[] args) {	
		System.out.println("Total on Dice - Average Number of Rolls");
		System.out.println("=======================================");
		for (int i = 2; i < 13; i++) {
			System.out.println(i + "   -   " + avgRoll(i));
		}
	}
	public static int roll(int num) {
		if (num < 2 || num > 12) {
			throw new IllegalArgumentException("Please enter a valid number : ");
		}
		int sum = 0;
		int count = 0;
		do {
			count++;
			sum = (int) ((Math.random()*6) + (Math.random()*6) + 2);
		} while (sum != num);
		return count;
	}
	public static double avgRoll(int num) {
		double sum = 0;
		for (int i = 0; i < 10000; i++) {
			sum += roll(num);
		}
		return sum / 10000;
	}
}

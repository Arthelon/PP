package Chapter5;
import support.StatCalc;

public class Chap5_3 {
	public static void main(String[] args) {
		Chap5_1 dice = new Chap5_1();
		
		for (int i = 2; i <= 12; i++) {
			StatCalc calc = new StatCalc();
			int count = 0;
			int sum = 0;
			do {
				int dieRoll = dice.getRoll();
				sum++;
				if (dieRoll == i) {
					count++;
					calc.enter(sum);
					sum = 0;
				}
			} while(count != 10000);
			System.out.println("Rolls statistics for "+i+" : ");
			System.out.println("Standard Deviation : " + calc.getStandardDeviation());
			System.out.println("Max Rolls : "+ calc.getMax());
		}
		
	}
}

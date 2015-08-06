package Chapter2;

public class Chap2_2 {
	public static void main(String[] args) {
		int firstDie = die();
		int secondDie = die();
		int sum = firstDie + secondDie;
		System.out.println("The first die comes up " + firstDie);
		System.out.println("The second die comes up " + secondDie);
		System.out.println("Your total roll is "+sum);
	}
	public static int die () {
		int roll = (int)(Math.random()*6) + 1;
		return roll;
	}
}

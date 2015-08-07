package Chapter3;

import java.util.ArrayList;

public class Chap3_7 {
	/** I have combined the 3 questions laid out into 1 class. Each question is represented
	 * with it's own subroutine  **/
	public static void main(String[] args) {
		question3();
	}
	public static void question1() {
		ArrayList<Integer> num = new ArrayList<Integer>();
		int count = 0;
		int same = 0;
		
		while (same != 3) {
			int newPerson = probab();
			if (num.contains(newPerson)) {
				same++;
			}
			count++;
			num.add(newPerson);
		}
		
		System.out.println("Number of people needed : "+ count);
	}
	public static void question2() {
		int[] num = new int[365];
		int count = 0;
		
		for (int i = 0; i < num.length; i++) { //Fills array with random numbers 1 - 365
			num[i] = probab();
		}
		
		for (int i = 0; i < num.length; i++) {
			for (int i2 = 0; i2 < num.length; i2++) {
				if (i2 == i) {
					continue;
				} else if (i2 == num.length-1 && num[i] != num[i2]) {
					count++;
				}
				else if (num[i] == num[i2]) {
					break;
				}
			}
		}
		
		System.out.println("Number of different birthdays : " + count);
	}
	public static void question3() {
		boolean[] num = new boolean[365];
		int count2 = 0;
		int count = 0;
		
		do {
			for (int i = 0; i < num.length; i++) {
				count2 = 0;
				num[probab()] = true;
				count++;
				if(!num[i]) {
					count2++;
				}
			}
			
		} while (count2 > 0);
		System.out.println("Number of people needed : "+count);
		}
	
	public static int probab() {
		return (int) (Math.random() * 365);
	}
}

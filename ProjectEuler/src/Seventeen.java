

import java.math.BigInteger;

public class Seventeen {
	public static void main(String[] args) {
		BigInteger num = BigInteger.valueOf(2);
		num = num.pow(1000);
		String newNum = "" + num;
		int sum = 0;
		for (int i = 0; i < newNum.length(); i++) {
			sum += Integer.parseInt(newNum.substring(i,i+1));
		}
		System.out.println(sum);
	}
}

import java.math.BigInteger;

public class Twenty {

	public static void main(String[] args) {
		BigInteger num = new BigInteger(""+BigInteger.ONE);
		int sum = 0;
		for (int i = 100; i > 0; i--) {
			num = num.multiply(new BigInteger("" + i));
		}
		String newNum = num.toString();
		for (int i = 0; i < newNum.length(); i++) {
			sum += Integer.parseInt(newNum.substring(i, i+1));
		}
		System.out.println(sum);
	}

}



public class Twelve {

	public static void main(String[] args) {
		long num = 0;
		long i = 1;
		while (numOfDiv(num) < 500) {
			num += i;
			i++;
		}
		System.out.println(num);
	}
	
	public static int numOfDiv(long num) {
		int count = 0;
		int limit = (int) Math.sqrt(num);
		for (int i = 1; i <= limit; i++) {
			if (num % i == 0) {
				count++;
				if (i != num/i) {
					count++;
				}
			} 
		}
		return count;
	}
}

public class Seven {
	private static boolean isPrime(long n)
	{
		if ((n % 2 == 0)&&(n != 2))
			return false;		
		for (long i = 3; i <= (n^(1/2)+1); i += 2)	{
			if (n % i == 0) return false;	
		}
		return true;
	}
 
	public static void main(String[] args) {
		int NumPrimes = 1;
		long i = 2;
		while(NumPrimes <= 10001) {
			if (isPrime(i)) {
				i++;
				NumPrimes++;
			} else i++;
		}
		System.out.println(i);
	}	
}
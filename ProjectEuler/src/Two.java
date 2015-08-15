
public class Two {
	
	public static void main(String[] args) {
		System.out.println(evenFib(1, 2));
	}
	//Used a recursive call to solve this problem
	public static int evenFib(int a, int b) {  
		if (a >= 4000000) return 0;
		if (a % 2 == 0) return a + evenFib(b, a+b);
		return evenFib(b, a+b);
	}

}

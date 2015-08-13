
public class Six {

	public static void main(String[] args) {
		int square1 = 0;
		int square2 = 0;
		for (int i = 1; i <= 100; i++) {
			square1 += i*i;
			square2 += i;
		}
		System.out.println(square2*square2-square1);
		

	}

}

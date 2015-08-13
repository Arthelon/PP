import java.util.ArrayList;


public class Nine {
	public static void main(String[] args) {
		ArrayList<Integer> a = new ArrayList<Integer>();
		ArrayList<Integer> b = new ArrayList<Integer>();
		ArrayList<Integer> c = new ArrayList<Integer>();
		int tA = 0;
		int tB = 0;
		int tC = 0;
		
		for (int i2 = 0; i2 < a.size(); i2++) {
			 int add = (a.get(i2) * a.get(i2) - 1)/2;
			 b.add(add);
			 c.add(add+1);
		}
		for (int i = 0; i < a.size(); i++) {
			if (a.get(i) + b.get(i) + c.get(i) == 1000) {
				tA = a.get(i);
				tB = b.get(i);
				tC = c.get(i);
				System.out.println("yes");
			}
		}
//		System.out.println("Product : "+ (tA*tB*tC));
	}

}

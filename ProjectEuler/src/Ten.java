import java.util.ArrayList;
import java.util.Collections;


public class Ten {
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		int p = 1;
		int constant;
		int nth = 10;
		
		list.add(2);
		for (int i2 = 3; i2 < nth/2; i2++) {
			p += 2;
			list.add(p);
			
		}
		System.out.println(list);
		for (int i3 = 0; i3 < list.size(); i3++) {
			p = list.get(i3);
			constant = p;
			for (int i4 = 0; i4 < list.size()/constant; i4++) {
				p += constant;
				list.remove(Integer.valueOf(p));
			}
		}
		System.out.println(list.get(list.size()-1));
	}
}

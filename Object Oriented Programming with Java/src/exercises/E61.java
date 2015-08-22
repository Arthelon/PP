package exercises;

import java.util.ArrayList;

public class E61 {
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		list.add("Hallo");
		list.add("Ciao");
		list.add("Hello");
		System.out.println("There are this many items in the list:");
		System.out.println(countItems(list));
	}
	
	public static int countItems(ArrayList<String> array) {
		return array.size();
	}
	
	public static void removeFirst(ArrayList<String> array) {
		array.remove(0);
	}
}

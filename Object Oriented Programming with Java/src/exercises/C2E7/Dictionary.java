package exercises.C2E7;

import java.util.ArrayList;
import java.util.HashMap;

public class Dictionary {
	private HashMap<String, String> list = new HashMap<String, String>();
	
	public String translate(String word) {
		if (!list.containsKey(word)) return "null";
		return list.get(word);
	}
	
	public void add(String word, String translation) {
		list.put(word, translation);
	}
	
	public int amountOfWords() {
		return list.size();
	}
	
	public ArrayList<String> translationList() {
		ArrayList<String> transList = new ArrayList<String>();
		for (String k : list.keySet()) {
			transList.add(k + " = " + list.get(k));
		}
		return transList;
	}
}

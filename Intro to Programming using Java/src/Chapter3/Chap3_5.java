package Chapter3;
import textIO.TextIO;

public class Chap3_5 {
	public static void main(String[] args) {
		TextIO.readUserSelectedFile();
		double sum = 0;
		int count = 0;
		while (!TextIO.eof()) {
			String str = TextIO.getln();
			
			for (int i = 0; i < str.length(); i++) {
				if (str.charAt(i) == ':') {
					str = str.substring(i+1);
					break;
				}
			}
			
			try {
				sum += Double.parseDouble(str);
			} catch (NumberFormatException num) {
				count++;
			}
			
		}
		System.out.println("Total sales : "+sum);
		System.out.println("Total cities with unavailable data : "+ count);
	}
}

package Chapter3;
import support.TextIO;

public class Chap3_4 {

	public static void main(String[] args) {
		System.out.println("Input something : ");
		String str = TextIO.getln();
		
		String newString = "";
		for (int i = 0; i < str.length(); i++) {
			if (Character.isLetter(str.charAt(i))) {
				newString += str.charAt(i);
			} else if (newString.length() > 0){
				System.out.println(newString);
				newString = "";
			} 
		}
		System.out.println(newString);

	}

}

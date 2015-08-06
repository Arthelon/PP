package Chapter2;
import textIO.TextIO;;

public class Chap2_7 {

	public static void main(String[] args) {
		
		TextIO.readUserSelectedFile();
		
		String name = TextIO.getlnWord();
		
		int score1 = TextIO.getlnInt();
		int score2 = TextIO.getlnInt();
		int score3 = TextIO.getlnInt();
		
		System.out.println("Students name : "+name+"\nAverage score : "+ (double)(score1+score2+score3)/3);
	}

}

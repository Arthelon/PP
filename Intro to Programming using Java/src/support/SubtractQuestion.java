package support;

public class SubtractQuestion implements IntQuestion{
	 private int a, b;  
	    public SubtractQuestion() { // constructor
	        a = (int)(Math.random() * 50 + 1);
	        b = (int)(Math.random() * 50);
	    }

	    public String getQuestion() {
	        return "What is " + a + " - " + b + " ?";
	    }

	    public int getCorrectAnswer() {
	        return a - b;
	    }
}

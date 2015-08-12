package Chapter5;

public class Chap5_1 {
    private int die1 = (int)(Math.random()*6) + 1;   
    private int die2 = (int)(Math.random()*6) + 1;   
    public static void main(String[] args) {
    	Chap5_1 die = new Chap5_1();
    	int roll = die.getRoll();
    	int count = 0;
    	while (roll != 2) {
    		count++;

    		roll = die.getRoll();
    	}
    	System.out.println(count);
    }
    public int getRoll() {
         die1 = (int)(Math.random()*6) + 1;
         die2 = (int)(Math.random()*6) + 1;
         return die1 + die2;
    }

    public int getDie1() {
    	return die1;
    }
    public int getDie2() {
    	return die2;
    }
    public String toString() {
    	return "" + die1 + die2;
    }

}

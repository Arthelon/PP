package Chapter5;
import support.*;

public class Chap5_4 {
	public static void main(String[] args) {
		BlackjackHand bj = new BlackjackHand();
		Deck deck = new Deck();
		
		deck.shuffle();
		for (int i = 0; i < (int)(Math.random() * 5) + 2; i++) {
			bj.addCard(deck.dealCard());
		}
		for (int i = 0; i < bj.getCardCount(); i++) {
			System.out.println(bj.getCard(i));
		}
		System.out.println("BlackJack Value : "  + bj.getBlackjackValue());
	}
}

package Chapter5;

import java.util.Scanner;

import support.BlackjackHand;
import support.Deck;

public class Chap5_5 {

	static Deck deck = new Deck();
	static BlackjackHand dealer = new BlackjackHand();
	static BlackjackHand player = new BlackjackHand();
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Chap5_5 chap = new Chap5_5();
		System.out.println("Welcome to Black Jack!");
		int game = 1;
		double money = 100;
		
		while (game == 1 && money > 0) {
			System.out.println("Your current balance is : $" + money + " How much do you want to bet?");
			double bet = scanner.nextDouble();
			player.clear();
			dealer.clear();
			chap.start();
			while (chap.check()) {
				System.out.println("Your Blackjack value is : " + player.getBlackjackValue());
				System.out.println("Hit (1), Stand (0)");
				int next = scanner.nextInt();
				if (next == 1) {
					player.addCard(deck.dealCard());
				} else {
					break;
				}
			}
			chap.dealCheck();
			if (chap.check() && player.getBlackjackValue() > dealer.getBlackjackValue()) {
				System.out.println("The dealer's Blackjack value is : "+dealer.getBlackjackValue());
				System.out.println("Your Blackjack value is : " + player.getBlackjackValue());
				System.out.println("Congragulations! You have won!");
				money += bet;
			} else {
				System.out.println("You lost with a Blackjack value of : " + player.getBlackjackValue());
				money -= bet;
				if (money <= 0) {
					System.out.println("Sorry! You are out of money to play with!");
					break;
				}
			}
			System.out.println("Another Round? Yes (1) No (0)");
			game = scanner.nextInt();
		}
		
	}
	
	public void start() {
		deck.shuffle();
		for (int i = 0; i < 2; i++) {
			dealer.addCard(deck.dealCard());
			player.addCard(deck.dealCard());
		}
	}
	
	public boolean check() {
		if (player.getBlackjackValue() > 21) return false;
		if (player.getBlackjackValue() == 21 && dealer.getBlackjackValue() == 21) return false;
		return true;
	}
	
	public void dealCheck() {
		while (dealer.getBlackjackValue() <= 16) dealer.addCard(deck.dealCard());
	}
}

/**
 * 
 */
package com.dk.card;

/**
 * @author d35kumar
 *
 */
public class Deck {

	Card cards[] = new Card[52];

	/**
	 * 
	 */
	public Deck() {
		int index = 0;
		for (CardType type : CardType.values()) {
			for (CardValue value : CardValue.values()) {
				cards[index++] = new Card(type, value);
			}
		}
	}

	public void printCardOrder() {
		System.out.println("Cards are currently in this order in deck");
		for (Card card : cards) {
			System.out.println(card);
		}
	}

}

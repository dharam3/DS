/**
 * 
 */
package com.dk.card;

/**
 * @author d35kumar
 *
 */
public class Card {

	private CardType type;
	private CardValue value;

	/**
	 * @param t
	 * @param v
	 */
	Card(CardType t, CardValue v) {
		this.type = t;
		this.value = v;
	}

	/**
	 * @return
	 */
	CardType getType() {
		return this.type;
	}

	/**
	 * @return
	 */
	CardValue getValue() {
		return this.value;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Card [type=" + type + ", value=" + value + "]";
	}
}

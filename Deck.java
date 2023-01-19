
/*
 * Tony Burwinkel
 * CS5004 Fall 2022
 * Final Project
 * Boss Monster
 */


import java.util.Collections;
import java.util.Stack;

	/**
	 * this class models a deck of cards
	 * all decks can be shuffled, and 
	 * cards can be drawn from Deck
	 * 
	 */
public abstract class Deck<T> {
	protected Stack<T> cards;
	
	/**
	 * create a new deck of cards
	 * decks delegate operations to
	 * a stack class, for which they are
	 * an adapter
	 */
	public Deck() {
		this.cards = new Stack<T>();
	}
	
	/**
	 * add an element of type T to the deck
	 * @param type
	 */
	public void add(T type) {
		this.cards.add(type);
	}
	
	/**
	 * shuffle the deck
	 */
	public void shuffle() {
		Collections.shuffle(cards);
	}
	
	/**
	 * draw an element from the deck
	 * @return element of type T at top of deck
	 */
	public T draw() {
		return cards.pop();
	}
	
	/**
	 * count the remaining elements in the deck
	 * @return number of elements left in the deck
	 */
	public int size() {
		return cards.size();
	}

}

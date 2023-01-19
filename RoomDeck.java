
/*
 * Tony Burwinkel
 * CS5004 Fall 2022
 * Final Project
 * Boss Monster
 */


/**
 * class representing a deck of heroes
 * constructor adds all heroes to a new deck
 */
public class RoomDeck extends Deck<Room>{

	public RoomDeck() {
		super();
		int i;
		for (i=0;i<2;i++) {
		this.cards.add(new Room("Spike Pit", 2, Sign.FIGHTER));
		this.cards.add(new Room("Lava Leap", 4, Sign.FIGHTER));
		this.cards.add(new Room("Coliseum Chamber", 2, Sign.FIGHTER));
		this.cards.add(new Room("Gong Room", 3, Sign.FIGHTER));
		this.cards.add(new Room("Boulder Roll", 2, Sign.THIEF));
		this.cards.add(new Room("Gem Room", 1, Sign.THIEF));
		this.cards.add(new Room("Gold Pile", 2, Sign.THIEF));
		this.cards.add(new Room("Rolex Factory", 3, Sign.THIEF));
		this.cards.add(new Room("Apothecary", 1, Sign.CLERIC));
		this.cards.add(new Room("Chapel Stall", 2, Sign.CLERIC));
		this.cards.add(new Room("Altar of Aims", 1, Sign.CLERIC));
		this.cards.add(new Room("Potion room", 2, Sign.CLERIC));
		this.cards.add(new Room("Warp tube", 1, Sign.MAGE));
		this.cards.add(new Room("Room of requirement", 1, Sign.MAGE));
		this.cards.add(new Room("Philosopher's Chamber", 2, Sign.MAGE));
		this.cards.add(new Room("Flame Library", 3, Sign.MAGE));
		}

	}

}

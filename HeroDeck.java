
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
public class HeroDeck extends Deck<Hero>{

	public HeroDeck() {
		super();
		this.cards.add(new Hero("Roger the Shrubber", Sign.CLERIC, 2, 1));
		this.cards.add(new Hero("Paladin Roy", Sign.CLERIC, 4, 2));
		this.cards.add(new Hero("Pope Pious", Sign.CLERIC, 3, 1));
		this.cards.add(new Hero("Nightcrawler", Sign.CLERIC, 4, 1));
		this.cards.add(new Hero("Tim", Sign.MAGE, 6, 1));
		this.cards.add(new Hero("Gandalf Greyhame", Sign.MAGE, 7, 2));
		this.cards.add(new Hero("Albus Dumbledore", Sign.MAGE, 5, 1));
		this.cards.add(new Hero("Professor Lupin", Sign.MAGE, 4, 1));
		this.cards.add(new Hero("Knights Who Say Ni", Sign.FIGHTER, 4, 1));
		this.cards.add(new Hero("Brave Sir Robin", Sign.FIGHTER, 2, 1));
		this.cards.add(new Hero("Arthur King of the Britons", Sign.FIGHTER, 6, 1));
		this.cards.add(new Hero("Boromir", Sign.FIGHTER, 7, 2));
		this.cards.add(new Hero("Garret", Sign.THIEF, 6, 1));
		this.cards.add(new Hero("Solid Snake", Sign.THIEF, 5, 1));
		this.cards.add(new Hero("Gollum", Sign.THIEF, 4, 1));
		this.cards.add(new Hero("Bilbo Baggins", Sign.THIEF, 2, 2));
	}

}

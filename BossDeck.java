
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
public class BossDeck extends Deck<Boss>{

	public BossDeck() {
		super();
		this.cards.add(new Boss("Balrog of Moria", Sign.MAGE));
		this.cards.add(new Boss("Dark Lord Sauron", Sign.MAGE));
		this.cards.add(new Boss("Shelob the Spider", Sign.FIGHTER));
		this.cards.add(new Boss("Darth Vader", Sign.FIGHTER));
		this.cards.add(new Boss("Radagast the Brown", Sign.CLERIC));
		this.cards.add(new Boss("Ozzy Osbourne", Sign.CLERIC));
		this.cards.add(new Boss("Robin Hood", Sign.THIEF));
		this.cards.add(new Boss("Peter Pettigrew", Sign.THIEF));
	}

}

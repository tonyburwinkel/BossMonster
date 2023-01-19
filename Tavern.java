
/*
 * Tony Burwinkel
 * CS5004 Fall 2022
 * Final Project
 * Boss Monster
 */


import java.util.LinkedList;

/**
 * class representing a tavern 
 * heroes gather in the tavern while waiting
 * to go to a dungeon to fight
 * 
 * Taverns are linked list adapters
 * they wrap a linkedlist and provide special 
 * dispatch functionality (by dungeon sign)
 */
public class Tavern {
	private LinkedList<Hero> heroes;

	/**
	 * create a new tavern with an empty 
	 * linked list for storing heroes
	 */
	public Tavern() {
		heroes = new LinkedList<Hero>();
	}
	
	/**
	 * sends heroes to the correct dungeon or has them stay in town
	 * depending on the number of signs of their type in the player
	 * and opponent's dungeons
	 * @param p
	 * @param o
	 */
	public String dispatchHeroes(Dungeon p, Dungeon o) {
		String returnString="";
		// make a list to hold heroes that don't get dispatched to a dungeon
		LinkedList<Hero> stayedInTown = new LinkedList<Hero>();
		// loop through the current heroes gathered in the tavern
		while (!(heroes.isEmpty())){
			Hero h = heroes.pop();
			Sign s = h.getSign();
			if (p.getNumSigns(s) == o.getNumSigns(s)) {
				stayedInTown.add(h); 
				returnString = returnString.concat(h.getName() +" stayed in town.\n");
				}
			else if (p.getNumSigns(s) > o.getNumSigns(s)) {
				p.queueHero(h);
				returnString = returnString.concat("dispatched " + h.getName() + " to your dungeon...\n");
				}
			else {
				o.queueHero(h);
				returnString=returnString.concat("dispatched " + h.getName() + " to opponent dungeon...\n");
			}
		}
		// any heroes that were not dispatched are put back into the tavern's heroes list
		heroes = stayedInTown;
		return returnString;
	}
	
	/**
	 * standard getter for linked list of heroes
	 * @return - this tavern's hero list
	 */
	public LinkedList<Hero> getHeroes() {
		return heroes;
	}
	
	/**
	 * add a hero to the hero list
	 * @param h hero to add
	 */
	public void addHero(Hero h) {
		this.heroes.add(h);
	}

	/**
	 * method for view to display heroes awaiting adventure
	 * @return string of all heroes in the tavern
	 */
	public String showTavern() {
		String showString = "";
		for (Hero h: heroes) {
			showString+=h.toString();
		}
		return showString;
	}
	
}

/*
 * Tony Burwinkel
 * CS5004 Fall 2022
 * Final Project
 * Boss Monster
 */

/**
 * this class represents the boss of a dungeon
 * bosses are the last room, and approximate
 * the emptynode at the end of a linked list
 * 
 */
public class Boss implements DungeonRoom {
	private String name;
	private int hp;
	private int coins;
	private Sign sign;

	/**
	 * create a new boss 
	 * @param name - name of boss
	 * @param sign - kind of hero that is attracted to
	 * this boss room
	 */
	public Boss(String name, Sign sign) {
		this.name = name;
		this.sign = sign;
		this.hp = 5;
		this.coins = 0;
	}
	
	// standard getters
	public String getName() {return this.name;}
	public int getHP() {return this.hp;}
	public Sign getSign() {return this.sign;}
	public int getCoins() {return this.coins;}

	/**
	 * base case of traversal of dungeon by heroes
	 * heroes that have made it this far while retaining
	 * any HP will do damage to the boss
	 * if the hero's HP is zero, the hero adds to the boss' coins
	 */
	public String defendAgainst(Hero h) {
		if (h.getHP()==0) {
			this.coins ++;
			return String.format("%s has vanquished %s\n", this.getName(), h.getName());
		}
		else this.hp-=h.getBP();
			return String.format("%s has bloodied %s\n", h.getName(), this.getName());
	}
	
	/**
	 * base case of show method
	 * used to print dungeon map
	 */
	public String show() {
		return this.toString();
	}
	
	/**
	 * return a string version of this boss
	 */
	public String toString() {
		return "BOSS \n" +
				name + "\n"
				+ "hp: " + Integer.toString(hp) + "\t"
				+ "coins: " + Integer.toString(coins) +"\t" 
				+ this.sign.name() + "\n\n";
	}

	/**
	 * iterator method, boss does not have a next node
	 */
	public boolean canAdvance() {
		return false;
	}

	/**
	 * iterator method, boss will return itself
	 */
	public DungeonRoom advance() {
		return this;
	}

}
